package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.JpaAdvancedApplication;
import com.springboot.jpaadvanced.entity.Course;
import com.springboot.jpaadvanced.entity.Passport;
import com.springboot.jpaadvanced.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = JpaAdvancedApplication.class)
class StudentRepositoryTest {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	StudentRepo repo;

	@Autowired
	EntityManager entityManager;

	@Test
	@Transactional // Persistence context is created
	@DirtiesContext
	public void someTest() {
		// Db op 1 - Retrieve student
		Student student = entityManager.find(Student.class, 100L);

		// Db op 2 - Retrieve passport
		Passport passport = student.getPassport();

		// Db op 3 - Update passport
		passport.setNumber("zxczcasd");

		// Db op 4 - Update student
		student.setName("Olivier");

	}

	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Student student = entityManager.find(Student.class, 100L);
		assertEquals("Abe", student.getName());
		assertEquals("e1234", student.getPassport().getNumber());
	}

	@Test
	@Transactional
	public void retrievePassportAndStudent() {
		Passport passport = entityManager.find(Passport.class, 1000L);
		assertEquals("e1234", passport.getNumber());
		assertEquals("Abe", passport.getStudent().getName());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = entityManager.find(Student.class, 100L);
		System.out.println(student);
		System.out.println(student.getCourses());
	}
}
