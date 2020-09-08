package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.entity.Course;
import com.springboot.jpaadvanced.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
public class CriteriaQueryTest {
    @Autowired
    EntityManager entityManager;

    @Test
    public void findAllCourses() {
        // Criteria query
        // 1. Use Criteria builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. Define Predicates etc using Criteria Builder

        // 4. Add Predicates etc to the Criteria Query

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    public void findAllCoursesLikeArch() {
        // Criteria query
        // 1. Use Criteria builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. Define Predicates etc using Criteria Builder
        Predicate like = criteriaBuilder.like(courseRoot.get("name"), "%Conc%");

        // 4. Add Predicates etc to the Criteria Query
        cq.where(like);

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    public void findAllCoursesWithoutStudents() {
        // Criteria query
        // 1. Use Criteria builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. Define Predicates etc using Criteria Builder
        Predicate like = criteriaBuilder.isEmpty(courseRoot.get("students"));

        // 4. Add Predicates etc to the Criteria Query
        cq.where(like);

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    public void join() {
        // Criteria query
        // 1. Use Criteria builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. Define Predicates etc using Criteria Builder
        Join<Object, Object> join = courseRoot.join("students");

        // 4. Add Predicates etc to the Criteria Query

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    public void leftJoin() {
        // Criteria query
        // 1. Use Criteria builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. Define Predicates etc using Criteria Builder
        Join<Object, Object> leftStudents = courseRoot.join("students", JoinType.LEFT);

        // 4. Add Predicates etc to the Criteria Query

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> courses = query.getResultList();
        System.out.println(courses);
    }
}
