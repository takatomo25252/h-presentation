package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Human;
import com.example.demo.repository.HumanRepository;

@Controller
public class HumanController {

	@Autowired
	Human human;

	@Autowired
	HumanRepository humanRepository;
	
}
