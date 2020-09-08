package com.spring.jpa.inheritancehierarchies;

import com.spring.jpa.inheritancehierarchies.entities.FullTimeEmployee;
import com.spring.jpa.inheritancehierarchies.entities.PartTimeEmployee;
import com.spring.jpa.inheritancehierarchies.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class InheritanceHierarchiesApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(InheritanceHierarchiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepo.insert(new FullTimeEmployee("Carter", new BigDecimal(10000)));
		employeeRepo.insert(new PartTimeEmployee("Bobby", new BigDecimal(50)));

		System.out.println(employeeRepo.getAllPartTimeEmployees());
		System.out.println(employeeRepo.getAllFullTimeEmployees());
	}
}
