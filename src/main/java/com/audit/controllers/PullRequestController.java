package com.audit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.entities.PullRequestWarraper;
import com.audit.entities.pojo.PullRequestResponse;
import com.audit.services.PullRequestServiceIntf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("api/")
@RestController
public class PullRequestController {

	@Autowired
	PullRequestServiceIntf pullRequestServiceIntf;
	
	@PostMapping("createPullRequest")
	public PullRequestResponse letsDowebhookPullRequest(@Valid @RequestBody PullRequestWarraper pullRequestWarraper) {
		PullRequestWarraper prWarraper = new PullRequestWarraper(pullRequestWarraper);
		prWarraper.setAction(pullRequestWarraper.getAction());
		log.debug("createPullRequest API executed with PullRequestWarraper: " + pullRequestWarraper);
		return pullRequestServiceIntf.createPullRequest(prWarraper);
	}
	
	@GetMapping("getPullRequestList")
	public List<PullRequestResponse> letsDoscreenshot() {
		log.debug("getPullRequestList API executed ");
		return pullRequestServiceIntf.getAllPullRequests();
	}
	
}
