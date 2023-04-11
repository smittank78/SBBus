package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.User;
import com.example.demo.service.DBService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(method = RequestMethod.GET,value = "/jpa")
@Log4j2
public class Handler 
{
	@Autowired
	private DBService service;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/getAll")
	public List<User> name() 
	{
		List<User> all = service.getAll();
		all.forEach(user -> 
		{
			log.info(user.toString());
		});
		return all;
	}
	@GetMapping("/getcreds")
	public String dataSource() 
	{
		return environment.getProperty("spring.datasource.url");
	}
}