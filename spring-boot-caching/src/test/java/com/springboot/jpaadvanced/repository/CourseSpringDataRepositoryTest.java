package com.springboot.jpaadvanced.repository;

import com.springboot.jpaadvanced.JpaAdvancedApplication;
import com.springboot.jpaadvanced.entity.Course;
import net.bytebuddy.TypeCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpaAdvancedApplication.class)
class CourseSpringDataRepositoryTest {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	CourseSpringDataRepo repo;

	@Test
	public void findById() {
		Optional<Course> courseOptional = repo.findById(10000L);
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void playAround() {
		System.out.println(repo.courseWithTeamInName());
		System.out.println(repo.courseWithTeamInNameNative());
	}

	@Test
	public void sort() {
		System.out.println(repo.findAll(Sort.by(Sort.Direction.DESC, "name")));
	}

	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> page = repo.findAll(pageRequest);
		System.out.println("First page " + page.getContent());

		Pageable pageable = page.nextPageable();
		Page<Course> secondPage = repo.findAll(pageable);
		System.out.println("Next page" + secondPage.getContent());
	}

	@Test
	public void findByName() {
		List<Course> courseOptional = repo.findByName("Team Project");
		assertFalse(courseOptional.isEmpty());
	}
}
