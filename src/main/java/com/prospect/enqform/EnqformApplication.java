package com.prospect.enqform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.prospect.*")
public class EnqformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnqformApplication.class, args);
	}

}
