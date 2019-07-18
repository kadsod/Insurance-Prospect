package com.prospect.aenqform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.prospect.repository.MetricsRepository;

@SpringBootApplication
@ComponentScan("com.prospect.*")
@EnableMongoRepositories(basePackageClasses = MetricsRepository.class)
public class EnqformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnqformApplication.class, args);
	}
	
	
}
