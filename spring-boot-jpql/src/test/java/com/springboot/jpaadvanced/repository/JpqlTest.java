package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.entity.Course;
import com.springboot.jpaadvanced.entity.Passport;
import com.springboot.jpaadvanced.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest
public class JpqlTest {
    @Autowired
    EntityManager entityManager;

    @Test
    public void findAllCourses() {
        List courses = entityManager.createQuery("Select c from Course c").getResultList();
        System.out.println(courses);
    }

    @Test
    // Better as it is typed
    public void findAllCoursesTyped() {
        TypedQuery<Course> query = entityManager.createNamedQuery("get_all_courses", Course.class);
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    // Better as it is typed
    public void findAllCoursesWhere() {
        TypedQuery<Course> query = entityManager.createNamedQuery("get_all_courses_where", Course.class);
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    // Better as it is typed
    public void findAllCoursesWithoutStudents() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select c from Course c where c.students is empty", Course.class);
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    // Better as it is typed
    public void findAllCoursesAtLeast2Students() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    // Better as it is typed
    public void findAllCoursesOrderedByNoOfStudents() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    // Better as it is typed
    public void findStudentPassportsWithPattern() {
        TypedQuery<Student> query =
                entityManager.createQuery("Select s from Student s where s.passport.number like '%123%'", Student.class);
        List<Student> students = query.getResultList();
        System.out.println(students);
    }

    @Test
    public void join() {
        // Courses without students will not be displayed
        Query query = entityManager.createQuery("Select c, s from Course c JOIN c.students s");
        List<Object[]> list = query.getResultList();
        // The resulting objects will be returned in a list depending in the order that
        // the query is executed: Course, Student => result[o].type = Course && result[1].type = Student
        for (Object[] result : list) {
            System.out.println("Course " + result[0]);
            System.out.println("Student " + result[1]);
        }
    }

    @Test
    public void leftJoin() {
        // Courses without students will be displayed
        Query query = entityManager.createQuery("Select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> list = query.getResultList();
        // The resulting objects will be returned in a list depending in the order that
        // the query is executed: Course, Student => result[o].type = Course && result[1].type = Student
        for (Object[] result : list) {
            System.out.println("Course " + result[0]);
            System.out.println("Student " + result[1]);
        }
    }

    @Test
    public void crossjoin() {
        // Cross join, it makes a cartesian product between the entities
        Query query = entityManager.createQuery("Select c, s from Course c, Student s");
        List<Object[]> list = query.getResultList();
        // The resulting objects will be returned in a list depending in the order that
        // the query is executed: Course, Student => result[o].type = Course && result[1].type = Student
        for (Object[] result : list) {
            System.out.println("Course " + result[0]);
            System.out.println("Student " + result[1]);
        }
    }
}
