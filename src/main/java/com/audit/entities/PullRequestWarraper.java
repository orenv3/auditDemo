package com.audit.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PullRequestWarraper {
	@JsonProperty("action")
	String action;
	
	@JsonProperty("number")
	int number;
	
	@JsonProperty("pull_request")
	PullRequest pull_request;
	
	@JsonProperty("repository")
	Repository repository;
	
	@JsonProperty("sender")
	Sender sender;
	
	public PullRequestWarraper(PullRequestWarraper prWarraper) {
		this.pull_request = new PullRequest(prWarraper.getPull_request());
	}
	
}
