package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class NativeQueriesTest {
    @Autowired
    EntityManager entityManager;

    @Test
    public void findAllCoursesParam() {
        // Native queries can support parameters
        Query query = entityManager.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
        query.setParameter(1, 10000);
        List courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    public void findAllCoursesNamedParam() {
        // Native queries can support parameters
        Query query = entityManager.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
        query.setParameter("id", 10000);
        List courses = query.getResultList();
        System.out.println(courses);
    }

    @Test
    @Transactional
    @DirtiesContext
    public void findAllCoursesUpdate() {
        // When a mass update is required use native query
        Query query = entityManager.createNativeQuery("UPDATE COURSE set last_updated_date=sysdate()", Course.class);
        int rowsUpdated = query.executeUpdate();
        System.out.println(rowsUpdated);
    }
}
