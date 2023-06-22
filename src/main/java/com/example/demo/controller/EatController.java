package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.EatRepository;

@Controller
public class EatController {

	@Autowired
	private EatRepository eatRepository;
	
	@GetMapping("/eat")
	public String index(Model m) {
		
		
		return "eat" ;
	}
	
	
			
			
		
	
	
	
}
