package com.tweetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;





@Entity
@Table(name = "USER", schema = "tweet5")
public class User {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private String id;
	
	private String username;
	private String first_name;
	private String last_name;
	private String password;
	
	private String email;
	
	private int age;
	
	private String gender;
	
	private int status;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User(String id, String username, String password, String email, int age, String gender, int status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.status = status;
	}

	public User() {
		super();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
	

	

}
