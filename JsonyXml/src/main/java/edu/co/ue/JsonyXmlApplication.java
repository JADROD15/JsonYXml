package edu.co.ue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.co.ue.second.controller"})
public class JsonyXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonyXmlApplication.class, args);
	}

}
