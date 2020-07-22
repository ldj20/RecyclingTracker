package com.LJ.RecyclingTrackerAPI.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.LJ.RecyclingTrackerAPI.domain.UserAccount;

public interface AccountRepository extends MongoRepository<UserAccount, String> {
	public UserAccount findByEmail(String email);
	public Optional<UserAccount> findById(String id);
}
