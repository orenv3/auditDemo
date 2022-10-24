package com.audit.printscreen;

import com.audit.entities.PullRequestWarraper;

public class PullRequestScreenshot extends PrintScreen{
	
	public PullRequestScreenshot(PullRequestWarraper prWarraer) {
		this.setName(this.getClass().getSimpleName());
		this.BASE_DIRECTOEY_PATH="C:\\pullRequest_screenshots";
		this.url = prWarraer.getPull_request().getHtml_url();
		setNameFormat(prWarraer.getPull_request().getCreated_at()
				,"ddMMyy",prWarraer.getPull_request().getUserName()
				, prWarraer.getAction()
				,prWarraer.getPull_request().getId()+"");
		createFilePath(BASE_DIRECTOEY_PATH);
	}
	
}
