package com.springboot.jdbcjpa;

import com.springboot.jdbcjpa.jdbc.PersonJdbcDAO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class JdbcJpaApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDAO personJdbcDAO;

	Logger logger = Logger.getLogger(JdbcJpaApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(JdbcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(personJdbcDAO.findAll().toString());
	}
}
