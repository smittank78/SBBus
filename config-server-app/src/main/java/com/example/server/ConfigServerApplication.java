package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/*
 * from this application, we are connecting with git and rabbitMQ and enabling the actuator.  
 * 
 * create bus with rabbitMQ where all application connected. 
 * when value changes in properties need to send request on http://localhost:8080/actuator/busrefresh. 
 * so value changes in all connected application with that bus.
 * 
 * dependency : 
 * - bus-amqp   ------>for rabbitMQ
 * - config-server  ------->config server holds information
 * - web-flux  
 * - actuator
 * - monitor  ---------> add webhook in git repo , when file updated git will send request on /monitor and all application get notified.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}