package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Comments;
import com.example.demo.repository.CommentRepository;

@Controller
public class NewCommentController {

	/*	@Autowired
		private EatRepository eatRepository;*/
	
	@Autowired
	private CommentRepository commentRepository;
	
@PostMapping("/write")
public String write(
	@RequestParam(name="newcomment", required=false) String newcomment,
	Model m
		) {
	
	Comments comments = new Comments(newcomment);
	
	commentRepository.save(comments);
	
	return "confirm";
}

	
	
	
			
		
	
	
	
}
