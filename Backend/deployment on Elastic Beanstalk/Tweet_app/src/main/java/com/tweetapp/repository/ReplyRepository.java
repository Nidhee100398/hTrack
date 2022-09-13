package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Reply2;



public interface ReplyRepository extends JpaRepository<Reply2,String> {
	
	List<Reply> findByTweetId(int tweetId);

}
