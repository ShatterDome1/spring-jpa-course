package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.JpaAdvancedApplication;
import com.springboot.jpaadvanced.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

@SpringBootTest(classes = JpaAdvancedApplication.class)
class CourseRepositoryTest {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	CourseRepo repo;

	@Test
	void findById() {
		Course course = repo.findById(10000L);
		assertEquals("Software Architecture", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteById() {
		repo.deleteById(10000L);
		assertNull(repo.findById(10000L));
	}

	@Test
	@DirtiesContext
	void save() {
		// Update
		Course course = repo.findById(10000L);
		course.setName("Edited");
		repo.save(course);
		assertEquals("Edited", repo.findById(10000L).getName());
	}
}
