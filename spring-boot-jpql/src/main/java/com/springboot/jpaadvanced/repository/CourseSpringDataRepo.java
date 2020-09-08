package com.springboot.jpaadvanced.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.jpaadvanced.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepo extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);

    @Query("select c from Course c where name like '%Team%'")
    List<Course> courseWithTeamInName();

    @Query(value = "Select * from course where name like '%Team%'", nativeQuery = true)
    List<Course> courseWithTeamInNameNative();
}
