package com.LJ.RecyclingTrackerAPI.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.LJ.RecyclingTrackerAPI.domain.UserAccount;

public interface AccountRepository extends MongoRepository<UserAccount, String> {
	public UserAccount findByEmail(String email);
}
