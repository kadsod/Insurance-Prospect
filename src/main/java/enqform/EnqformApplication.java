package enqform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import controller.FormController;

@SpringBootApplication
@ComponentScan(basePackageClasses = FormController.class)
public class EnqformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnqformApplication.class, args);
	}

}
