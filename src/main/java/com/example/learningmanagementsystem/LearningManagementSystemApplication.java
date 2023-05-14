package com.example.learningmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LearningManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LearningManagementSystemApplication.class, args);
		System.out.println("Application running");
	}

}
