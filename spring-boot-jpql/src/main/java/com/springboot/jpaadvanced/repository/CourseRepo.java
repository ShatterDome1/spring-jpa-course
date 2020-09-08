package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.entity.Course;
import com.springboot.jpaadvanced.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepo {
    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null)
            entityManager.persist(course);
        else
            entityManager.merge(course);

        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void playWithEM() {
        Course course = new Course("Cart wheel");
        entityManager.persist(course);

        Course modCourse = findById(10000L);
        modCourse.setName("Updated");
        entityManager.merge(modCourse);
    }

    public void getAllReviewsByCourseId(Long id) {
        Course course = findById(id);
        System.out.println(course.getReviews());
    }

    public void addReviewToCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);

        for (Review review : reviews) {
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }
}
