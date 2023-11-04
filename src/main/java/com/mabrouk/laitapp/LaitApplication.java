package com.mabrouk.laitapp;

import com.mabrouk.laitapp.model.RoleType;
import com.mabrouk.laitapp.model.Roles;
import com.mabrouk.laitapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class LaitApplication {

	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(LaitApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRpository){
		return args -> {

				roleRpository.save(new Roles( RoleType.ROLE_USER));
			roleRpository.save(new Roles( RoleType.ROLE_ADMIN));

		};
	}
}
