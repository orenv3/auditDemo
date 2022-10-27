package com.audit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.entities.Picture;
import com.audit.entities.PullRequest;
import com.audit.entities.PullRequestWarraper;
import com.audit.entities.pojo.PullRequestResponse;
import com.audit.printscreen.PullRequestScreenshot;
import com.audit.repo.PicturesRepo;
import com.audit.repo.PullRequestRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PullRequestService implements PullRequestSrvInterface{

	@Autowired
	PullRequestRepo pullRequestRepo;

	@Autowired
	PicturesRepo picturesRepo;

	@Override
	public PullRequestResponse createPullRequest(PullRequestWarraper pullRequestWarraper) {
		log.debug("creating PullRequestWarraper details: " + pullRequestWarraper);
		PullRequestScreenshot pullRequestScreenshot = new PullRequestScreenshot(pullRequestWarraper);
		pullRequestScreenshot.start();
		PullRequest pullRequest = pullRequestWarraper.getPull_request();
		log.debug("creating pull request details: " + pullRequest);
		PullRequestResponse response = new PullRequestResponse();

		Picture p = picturesRepo.save(pullRequestScreenshot.getPicture());
		pullRequest.setPicture(p); 
		response.setPullRequest(pullRequestRepo.save(pullRequest));
		log.debug("sending response details: " + response);
		return response;
	}

	@Override
	public List<PullRequestResponse> getAllPullRequests() {
		List<PullRequestResponse> prList = new ArrayList<>();
		log.debug("Method getAllPullRequests executed");
		pullRequestRepo.findAll().forEach(c -> prList.add(new PullRequestResponse(c)));
		log.debug("List<PullRequestResponse> details: "+prList);
		return prList;
	}

	@Override
	public PullRequestResponse findPullRequestById(long id) {
		Optional<PullRequest> optionalPullRequest = pullRequestRepo.findById(id);
		PullRequestResponse pullRequestResponse = new PullRequestResponse();
		if(optionalPullRequest.isEmpty()) {
			pullRequestResponse.setPullRequest(new PullRequest());
		}else {
			pullRequestResponse.setPullRequest(optionalPullRequest.get());
		}
		return pullRequestResponse;
	}


}
