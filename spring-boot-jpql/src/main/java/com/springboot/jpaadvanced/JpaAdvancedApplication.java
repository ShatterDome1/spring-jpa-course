package com.springboot.jpaadvanced;

import com.springboot.jpaadvanced.entity.Course;
import com.springboot.jpaadvanced.entity.Review;
import com.springboot.jpaadvanced.entity.Student;
import com.springboot.jpaadvanced.repository.CourseRepo;
import com.springboot.jpaadvanced.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class JpaAdvancedApplication implements CommandLineRunner {
	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private StudentRepo studentRepo;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentRepo.saveStudentWithPassport();
		//courseRepo.getAllReviewsByCourseId(10000L);
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review(4,"It worked"));
//		reviews.add(new Review(2, "Unpleasant"));
//
//		courseRepo.addReviewToCourse(10000L, reviews);

		//studentRepo.insertStudentAndCourse(new Student("Jack"), new Course("Micro"));
	}
}
