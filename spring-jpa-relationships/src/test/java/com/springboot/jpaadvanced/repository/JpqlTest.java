package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.entity.Course;
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
}
