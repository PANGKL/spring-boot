package com.bootcamp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@SpringBootApplication
// 1.SpringBootConfiguration
// 2.EnableAutoConfiguration

// 3.ComponentScan
// 3.1 is to scan @Controller, @Service, @Repo, @Config,
// if yes, create an object of those classes and put that object into SpringContext
public class DemoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootApplication.class, args);

	}

}
