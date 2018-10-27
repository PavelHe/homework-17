package com.example.demo;

import java.util.*;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DockerMysqlSpringApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DockerMysqlSpringApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void createUsers() {
		List<User> users = repository.findAll();
		if (users.size() > 0)
			repository.deleteAll();

		repository.save(new User("Alex"));
		repository.save(new User("Andrey"));
		repository.save(new User("Bill"));
		System.out.println(repository.findAll());
	}
}
