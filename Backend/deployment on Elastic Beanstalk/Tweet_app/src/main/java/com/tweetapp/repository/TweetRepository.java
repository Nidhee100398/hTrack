package com.tweetapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,String> {
	
	List<Tweet> findByEmail(String email);
	
	Tweet findByEmailAndId(String email,String id);
	
	Optional<Tweet> findById(String id);

	Tweet save(Optional<Tweet> tweet);

}
