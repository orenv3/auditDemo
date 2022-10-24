package com.audit.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.OptBoolean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@Table
public class PullRequest {

	@JsonProperty("url")
	private String url;
	
	@Id
	@Min(value = 1)
	@JsonProperty("id")
    private long id;
	
	@JsonProperty("node_id")
    private String node_id;
    
	@NotBlank
	@JsonProperty("html_url")
    private String html_url;
	
	@JsonProperty("diff_url")
    private String diff_url; 
	
	@JsonProperty("issue_url")
    private String issue_url;
	
	@JsonProperty("number")
    private int number;
	@JsonProperty("state")
    private String state;
	
	@JsonProperty("title")
    private String title;
	
	@JsonProperty("user")
	@Transient
    private User user;
	
	private String userName;
    
   
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",lenient = OptBoolean.FALSE)
    private Date created_at;
  
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",lenient = OptBoolean.FALSE)
    private Date updated_at; 
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",lenient = OptBoolean.FALSE)
    private Date merged_at;

	public PullRequest(PullRequest pr) {
		super();
		this.url = pr.url;
		this.id = pr.id;
		this.node_id = pr.node_id;
		this.html_url = pr.html_url;
		this.diff_url = pr.diff_url;
		this.issue_url = pr.issue_url;
		this.number = pr.number;
		this.state = pr.state;
		this.title = pr.title;
		this.userName = pr.user.getLogin();
		this.created_at = pr.created_at;
		this.updated_at = pr.updated_at;
		this.merged_at = pr.merged_at;
	}
   }
