package com.LJ.RecyclingTrackerAPI.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepostioryCustom {
	@Query("SELECT UserAccount FROM Object UserAccount WHERE UserAccount.connectedCode = inputCode")
	public List<Object> findAllWithCode(String inputCode);
}
