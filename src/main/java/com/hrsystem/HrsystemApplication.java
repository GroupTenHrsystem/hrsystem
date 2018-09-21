package com.hrsystem;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HrsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrsystemApplication.class, args);
	}
}
