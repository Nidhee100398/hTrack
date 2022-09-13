package com.tweetapp.controller;


import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.tweetapp.configuration.ProducerService;
import com.tweetapp.model.Login;
import com.tweetapp.model.User;
import com.tweetapp.service.LoginService;

@RestController
@RequestMapping("/api/v1.0/tweets")

public class LoginController {
	
	@Autowired
	LoginService loginService;
	
//	@Autowired
	//ProducerService producerService;
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);

	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) throws Exception {
	//	this.producerService.sendMessage( user.getEmail());
		return loginService.registerUser(user);
	}
	
	@PostMapping(value = "/publish")
	  public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		    logger.log(Level.INFO,message);
	      //  this.producerService.sendMessage(message);
	  }
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:3000")
	public User login(@RequestBody Login login) throws Exception {
		
		return loginService.login(login);
	}
	
	@PostMapping("/logout")
	public String logout(@RequestParam String email) throws Exception {
		
		return loginService.logout(email);
	}
	
	
	@GetMapping("/{email}/forgot")
	public User forgetPassword(@PathVariable String email) throws Exception {
		
		return loginService.forgetPassword(email);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody Login login) {
		
		return loginService.updateUser(login);
	}
	
	@GetMapping("/users/all")
	public List<User> getAllUsers() {
		return loginService.getAllUsers();
	}
	
	@GetMapping("/user/search/{username}")
	public List<User> getUsersByName(@PathVariable String username) {
		
		return loginService.getUsersByName(username);
	}
	

}
