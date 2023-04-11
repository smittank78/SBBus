package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * after changes in git and once request sent on busrefresh of config server 
 * checking that properties values changed here or not 
 * 
 * application name same as file name on git-hub.
 * spring.config.import=configserver:link-of-config-server
 * and connect with rabbitMq
 * 
 * dependency : 
 * 
 * - config-client
 * - cloud-starter-bus-amqp
 * - actuator
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication
{
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Autowired
	private Environment environment;
	
	@EventListener(value = {ApplicationReadyEvent.class,RefreshScopeRefreshedEvent.class})
	public String name() 
	{
		System.out.println("**************** Event Refreshed ****************");
		String phase = environment.getProperty("spring.phase");
		System.out.println("phase : " + phase);
		return phase;
	}
}