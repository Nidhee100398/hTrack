package com.tweetapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "Tweet")
public class Tweet {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id")
	private String id;
    private String username;
    private String email;
    private String tweets;
    private String date;
    @Column(name = "likes")
    private int like;
    private int dislike;
    private String replies;
   // private List<Reply> replies;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTweets() {
		return tweets;
	}
	public void setTweets(String tweets) {
		this.tweets = tweets;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	
	
	
	

	public int getDislike() {
		return dislike;
	}
	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
	
	public Tweet() {
		super();
	}
	public Tweet(String id, String username, String email, String tweets, String date, int like, int dislike,
			List<Reply> replies) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.tweets = tweets;
		this.date = date;
		this.like = like;
		this.dislike = dislike;
		//this.replies = replies;
	}
	public String getReplies() {
		return replies;
	}
	public void setReplies(String replies) {
		this.replies = replies;
	}

	
	
	
	
    
    

}
