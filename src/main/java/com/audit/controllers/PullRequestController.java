package com.audit.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.entities.PullRequest;
import com.audit.entities.PullRequestWarraper;
import com.audit.entities.pojo.PullRequestResponse;
import com.audit.services.PullRequestSrvInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("api/pullRequest")
@RestController
public class PullRequestController {

	@Autowired
	PullRequestSrvInterface pullRequestServiceIntf;

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

	@GetMapping("getPullRequest/{id}")
	public PullRequestResponse getPullRequestById(@PathVariable("id") long id) {
		return pullRequestServiceIntf.findPullRequestById(id);
	}
}
