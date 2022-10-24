package com.audit.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

	private String login;
	private long id;
	private String node_id;
	private String avatar_url;
	private String gravatar_id;
	private String url;
	private String html_url;
	private String followers_url;
	private String following_url;
	private String gists_url;
	private String starred_url;
	private String subscriptions_url;
	private String organizations_url;
	private String repos_url;
	private String events_url;
	private String received_events_url;
	private String type;
	private boolean site_admin;
	
	public User(User u) {
		super();
		this.login = u.login;
		this.id = u.id;
		this.node_id = u.node_id;
		this.avatar_url = u.avatar_url;
		this.gravatar_id = u.gravatar_id;
		this.url = u.url;
		this.html_url = u.html_url;
		this.followers_url = u.followers_url;
		this.following_url = u.following_url;
		this.gists_url = u.gists_url;
		this.starred_url = u.starred_url;
		this.subscriptions_url = u.subscriptions_url;
		this.organizations_url = u.organizations_url;
		this.repos_url = u.repos_url;
		this.events_url = u.events_url;
		this.received_events_url = u.received_events_url;
		this.type = u.type;
		this.site_admin = u.site_admin;
	}
	
	

}

