package com.go2geda;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication @OpenAPIDefinition
public class Go2GedaApplication {

	public static void main(String[] args) {

		SpringApplication.run(Go2GedaApplication.class, args);
	}
}
