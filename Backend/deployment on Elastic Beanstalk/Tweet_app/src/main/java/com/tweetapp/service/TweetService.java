package com.tweetapp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Reply2;
import com.tweetapp.model.ReplyDTO;
import com.tweetapp.model.ReplyTweet;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.User;
import com.tweetapp.repository.LoginRepository;
import com.tweetapp.repository.ReplyRepository;
import com.tweetapp.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	TweetRepository tweetRepository;
	
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	ReplyRepository replyRepo;
	
	public List<Tweet> getAllTweets() {
		
		return tweetRepository.findAll();
	}
	
	public List<Tweet> getAllTweetsByUser(String email) {
		
		return tweetRepository.findByEmail(email);
	}
	public Tweet findByEmailAndId(String email,String id)
	{
		return tweetRepository.findByEmailAndId(email, id);
	}
	
	public String postTweet(String email,String tweetDesc) {
	
		
		tweetDesc = tweetDesc.replace("=", "");
		
		if(tweetDesc.contains("+"))
		{
			tweetDesc = tweetDesc.replace("+", " ");
		}
		System.out.print("ck "+tweetDesc);
		List<User> userList = loginRepository.findByEmail(email);
		
		Tweet tweet = new Tweet();
		tweet.setUsername(userList.get(0).getUsername());
		tweet.setEmail(userList.get(0).getEmail());
		tweet.setTweets(tweetDesc);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
		tweet.setDate(dtf.format(now));
		tweet.setLike(0);
		tweet.setDislike(0);
		String replies = null;
	tweet.setReplies(replies);
		Tweet tweets = tweetRepository.save(tweet);
		
		return tweets.getId();
	}
	
	public int likeTweet(String email,String id) {
		
		Tweet tweet = tweetRepository.findByEmailAndId(email, id);
		
		int count = tweet.getLike();
		tweet.setLike(count+1);
		tweetRepository.save(tweet);
		
		return tweet.getLike();
		
	}
	
public int disLikeTweet(String email,String id) {
		
		Tweet tweet = tweetRepository.findByEmailAndId(email, id);
		
		int count = tweet.getDislike();
		tweet.setDislike(count+1);
		tweetRepository.save(tweet);
		
		return tweet.getDislike();
		
	}
	
	public Tweet updateTweet(String email,String id,String tweetDesc) {
		
		
		tweetDesc = tweetDesc.replace("\"","");
		System.out.println(tweetDesc);
		Tweet tweet =tweetRepository.findByEmailAndId(email, id);
		
		tweet.setTweets(tweetDesc);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
		tweet.setDate(dtf.format(now));
		
		tweetRepository.save(tweet);
		
		return tweet;
		
	}
	
	public String deleteTweet(String email,String id) {
		Tweet tweet =tweetRepository.findByEmailAndId(email, id);
		tweetRepository.delete(tweet);
		
		return "deleted";
	}
	
	public Tweet replyTweet(String email,String id,String reply) {
	
		//Tweet tweet1 =tweetRepository.findByEmailAndId(email, id);
		//List<Reply> replies = tweet.getReplies();
	//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	//	LocalDateTime now = LocalDateTime.now(); 
	//	reply.setDate(dtf.format(now));
//		replies.add(reply);
			//tweet.setReplies(replies);
		
		Tweet tweet = new Tweet();
		List<User> userList = loginRepository.findByEmail(email);
		List<Tweet> userTweet=tweetRepository.findByEmail(email);
	
		String replies=reply;

		System.out.println("Tweet "+tweet);
		tweet.setTweets(userTweet.get(0).getTweets());
	
        tweet.setEmail(email);
        tweet.setUsername(userList.get(0).getUsername());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
		tweet.setDate(dtf.format(now));
		tweet.setReplies(replies);
		
	
		
		return tweetRepository.save(tweet);
		
	}

	

	private Tweet replyTweetTo(String email,com.tweetapp.model.ReplyTweet tweet, String id) {
		Tweet tweetJpa = new Tweet();
		List<User> userList = loginRepository.findByEmail(email);
		tweetJpa.setUsername(userList.get(0).getUsername());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
		tweetJpa.setEmail(userList.get(0).getEmail());
		tweetJpa.setDate(dtf.format(now));
		tweetJpa.setTweets(tweet.getDescription());
	   // tweetJpa.setReplies(id);
		return tweetJpa;
	}

//	public Tweet replyTweet(String email, String id, ReplyTweet reply) {
//		// TODO Auto-generated method stub
//       Tweet tweetJpa = replyTweetTo(email,reply, id);
//		
//		tweetRepository.save(tweetJpa);
//		return tweetRepository.save(tweetJpa);
//		
//	}
	public String postReply(ReplyDTO replyDTO, String email, Tweet id) {
        // TODO Auto-generated method stub
        
        Reply2 reply = converttDTOToReplyEntity(replyDTO,email,id);
        replyRepo.save(reply);
        String msg = null;
        if (reply != null) {
            msg = "Success";
            return msg;
        } else {
            msg = "Internal Server Error Occured";
        }
        return msg;
    }
	
	   public Reply2 converttDTOToReplyEntity(ReplyDTO replyDTO,String email,Tweet id) {
	        List<User> userList = loginRepository.findByEmail(email);
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	        LocalDateTime now = LocalDateTime.now();



	       Reply2 reply = new Reply2();
	        reply.setEmail(userList.get(0).getEmail());
	        //reply.setTweet(tweet.get(0));
	        reply.setTweetId(replyDTO.getTweetId());
	        reply.setReplyDesc(replyDTO.getReplyDesc());
	        reply.setDate(dtf.format(now));
	        reply.setTweet(id);
	    



	       return reply;
	    }

	public List<Reply2> getAllReply() {
		// TODO Auto-generated method stub
		return replyRepo.findAll();
	}
	
	
}
