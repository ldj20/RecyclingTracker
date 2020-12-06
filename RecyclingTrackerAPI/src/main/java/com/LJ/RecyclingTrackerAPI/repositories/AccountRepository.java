package com.LJ.RecyclingTrackerAPI.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.LJ.RecyclingTrackerAPI.model.User;

public interface AccountRepository extends MongoRepository<User, String> {
	public User findByEmail(String email);
	public Optional<User> findById(String id);
}
