package com.audit.printscreen;

import com.audit.entities.Picture;
import com.audit.entities.PullRequestWarraper;

public class PullRequestScreenshot extends PrintScreen{
	
	
	
	public PullRequestScreenshot(PullRequestWarraper prWarraer) {
		this.setName(this.getClass().getSimpleName());
		setNameFormat(prWarraer.getPull_request().getCreated_at()
				,"ddMMyy",prWarraer.getPull_request().getUserName()
				, prWarraer.getAction()
				,prWarraer.getPull_request().getPullRequest_id()+"");
		this.picture = new Picture(this.strBuilder.toString());
		
		this.BASE_DIRECTOEY_PATH="C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\myApp\\pullRequest_screenshots";
		createFilePath(BASE_DIRECTOEY_PATH);
//		this.BASE_DIRECTOEY_PATH="C:\\pullRequest_screenshots";
		this.url = prWarraer.getPull_request().getHtml_url();
	}
	
	
	
}
