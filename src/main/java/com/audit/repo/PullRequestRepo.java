package com.audit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.entities.PullRequest;

@Repository
public interface PullRequestRepo extends JpaRepository<PullRequest, Long>{

}
