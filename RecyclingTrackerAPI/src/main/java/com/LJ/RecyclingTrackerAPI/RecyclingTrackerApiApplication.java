package com.LJ.RecyclingTrackerAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.LJ.RecyclingTrackerAPI.domain.UserAccount;
import com.LJ.RecyclingTrackerAPI.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class RecyclingTrackerApiApplication /*implements CommandLineRunner*/ {

	@Autowired
	private AccountRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(RecyclingTrackerApiApplication.class, args);
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		
		repository.save(new UserAccount("a@a.a"));
		repository.save(new UserAccount("c@c.c"));
			
		System.out.println(repository.findByEmail("a@a.a").getEmail());
	}
	*/
}


