package com.go2geda;

import com.go2geda.data.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Go2GedaApplication {

	public static void main(String[] args) {

		SpringApplication.run(Go2GedaApplication.class, args);
		User user = new User();
		user.setEmail("jjo2@gmail.com");

		System.out.println(user.getEmail());
		System.out.println(user.getId());
	}

}
