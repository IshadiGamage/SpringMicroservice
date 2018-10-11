package com.pearson.nextgen.safeassignapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SafeassignApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeassignApiApplication.class, args);
		System.out.println("==== Application is running ====");
	}
}
