package com.tweetapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ReplyTweet {
	@Size(min = 1, max = 150, message = "The tweet description must be between {min} and {max} characters long")
	@NotBlank(message = "Tweet is mandatory")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
