package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.entity.Course;
import com.springboot.jpaadvanced.entity.Passport;
import com.springboot.jpaadvanced.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepo {
    @Autowired
    EntityManager entityManager;

    public void saveStudentWithPassport() {
        Passport passport = new Passport("asdasd123");
        entityManager.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course) {
        student.addCourse(course);
        course.addStudent(student);

        entityManager.persist(student);
        entityManager.persist(course);
    }
}
