package com.audit;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.audit.*"})
@EntityScan(basePackages = "com.audit.entities")
@EnableJpaRepositories(basePackages = "com.audit.repo")
@Configuration
public class AuditConfiguration {

}
