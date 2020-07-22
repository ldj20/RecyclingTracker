package com.LJ.RecyclingTrackerAPI.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.LJ.RecyclingTrackerAPI.domain.UserAccount;

@Repository
public interface ObjectRepostioryCustom {
	@Query("SELECT UserAccount FROM Object UserAccount WHERE UserAccount.connectedCode = inputCode")
	public List<UserAccount> findAllWithCode(String inputCode);
}
