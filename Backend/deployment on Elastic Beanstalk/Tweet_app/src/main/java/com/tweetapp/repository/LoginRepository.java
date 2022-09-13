package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User,String>{
	
	List<User> findByEmail(String email);
	
	List<User> findByUsername(String name);
	
	List<User> findByEmailAndPassword(String email,String password);

}
