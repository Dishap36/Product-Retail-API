package com.cognixia.jump.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.User;

@Repository
public interface UserRepository  extends MongoRepository<User, Long>{ // JpaRepository< table, id/primary key>

	// custom query for finding users by username
	// important for security, security will only know how to find a user by the username
	// Optional -> possiblity that no user exixts with this username, so we represent that with an optional (could be null)
	public Optional<User> findByUsername(String username);
	
	
}
