package com.LJ.RecyclingTrackerAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LJ.RecyclingTrackerAPI.domain.UserAccount;
import com.LJ.RecyclingTrackerAPI.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecyclingTrackerApiApplication implements CommandLineRunner {

	@Autowired
	private AccountRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(RecyclingTrackerApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("a");
		repository.deleteAll();
		
		repository.save(new UserAccount("a@a.a"));
		repository.save(new UserAccount("b@b.b"));
			
		System.out.println(repository.findByEmail("a@a.a").getEmail());
	}
}


