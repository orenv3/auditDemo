package com.audit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.audit.entities.Picture;
import com.audit.entities.PullRequest;
import com.audit.entities.PullRequestWarraper;
import com.audit.entities.pojo.PullRequestResponse;

@Service
public interface PullRequestSrvInterface {

	PullRequestResponse createPullRequest(PullRequestWarraper pullRequestWarraper);
	
	List<PullRequestResponse> getAllPullRequests();
	
	PullRequestResponse findPullRequestById(long id);
}
