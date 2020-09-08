package com.spring.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicsApplication {

	// What are the beans? @Component
	// What are the dependencies for a bean @Autowired
	// Where to search for beans => No need, same package

	public static void main(String[] args) {
		//BinarySearch binarySearch = new BinarySearch(new BubbleSort());

		// Beans are managed by the ApplicationContext
		ApplicationContext context = SpringApplication.run(BasicsApplication.class, args);
		BinarySearch binarySearch = context.getBean(BinarySearch.class);
		int result = binarySearch.binarySearch(new int[] {1,2,3}, 4);
	}

}
