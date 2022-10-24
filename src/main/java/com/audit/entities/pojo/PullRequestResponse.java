package com.audit.entities.pojo;

import com.audit.entities.PullRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PullRequestResponse {

	private PullRequest pullRequest;
	private String msg;
	
	public PullRequestResponse(PullRequest pr) {
		this.pullRequest = pr;
	}
}
