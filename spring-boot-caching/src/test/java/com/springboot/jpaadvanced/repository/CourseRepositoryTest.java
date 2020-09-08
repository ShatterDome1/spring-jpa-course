package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.JpaAdvancedApplication;
import com.springboot.jpaadvanced.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;

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

	// First level caching is done at the transaction level
	// If data that has been retrieved in a transaction is
	// fetched again, a second fetch is not performed
	@Test
	@Transactional
	void firstLevelCaching() {
		Course course = repo.findById(10000L);
		assertEquals("Software Architecture", course.getName());
		System.out.println("First fetch");

		Course course1 = repo.findById(10000L);
		assertEquals("Software Architecture", course1.getName());
		System.out.println("Second fetch");
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
