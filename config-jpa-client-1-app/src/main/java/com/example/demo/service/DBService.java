package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.User;
import com.example.demo.repo.UserRepo;

@Service
public class DBService 
{
	@Autowired
	private UserRepo repo;
	
	public List<User> getAll() 
	{
		return repo.findAll();
	}
}