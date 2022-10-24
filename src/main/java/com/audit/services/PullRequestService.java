package com.audit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.entities.PullRequest;
import com.audit.entities.PullRequestWarraper;
import com.audit.entities.pojo.PullRequestResponse;
import com.audit.printscreen.PullRequestScreenshot;
import com.audit.repo.PullRequestRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PullRequestService implements PullRequestServiceIntf{

	@Autowired
	PullRequestRepo pullRequestRepo;
	
	@Override
	public PullRequestResponse createPullRequest(PullRequestWarraper pullRequestWarraper) {
		log.debug("creating PullRequestWarraper details: " + pullRequestWarraper);
		PullRequestScreenshot pullRequestScreenshot = new PullRequestScreenshot(pullRequestWarraper);
		pullRequestScreenshot.start();
		PullRequest pr = pullRequestWarraper.getPull_request();
		log.debug("creating pull request details: " + pr);
		PullRequestResponse response = new PullRequestResponse();
		response.setPullRequest(pullRequestRepo.save(pr));
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

}
