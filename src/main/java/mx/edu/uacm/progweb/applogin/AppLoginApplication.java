package mx.edu.uacm.progweb.applogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AppLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppLoginApplication.class, args);
	}

}
