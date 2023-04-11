package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import jakarta.annotation.PostConstruct;
/*
 * fetch database : cred from .git file
 * when creds updated in git after that just need to busrefresh on config server and re-run this app.
 * 
 * application name same as file name on git-hub.
 * spring.config.import=configserver:link-of-config-server
 * and connect with rabbitMq
 * 
 * dependency : 
 * 
 * - config-client
 * - cloud-starter-bus-amqp
 * - mysql-connector
 * - data-jpa
 * - actuator
 */
@SpringBootApplication
public class ConfigJpaClient1Application 
{
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(ConfigJpaClient1Application.class, args);
	}

	@EventListener(value = {RefreshScopeRefreshedEvent.class,ApplicationReadyEvent.class})
	@PostConstruct
	public void dataSource1() 
	{
		System.out.println("************ Connection Modiefied ************");
		System.out.println(environment.getProperty("spring.datasource.url") + " activated by smit");
	}
}