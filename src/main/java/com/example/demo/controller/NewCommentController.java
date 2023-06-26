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
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "eatid", required = false) Integer eatid,
			@RequestParam(name = "bango", required = false) Integer bango,
			@RequestParam(name = "namae", required = false) String namae,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "newcomment", required = false) String newcomment,
			Model m) {

		Comments comments = new Comments(eatid, bango, namae, newcomment);

		commentRepository.save(comments);
		
		m.addAttribute("comments", comments);

		return "confirm";
	}
	@PostMapping("/update")
	public String update(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "eatid", required = false) Integer eatid,
			@RequestParam(name = "bango", required = false) Integer bango,
			@RequestParam(name = "namae", required = false) String namae,
			@RequestParam(name = "comment", required = false) String comment,
			Model m) {

		Comments comments = new Comments(eatid, bango, namae, comment);

		m.addAttribute("comments", comments);
		
		

		return "redirect:/kutikomi";
	}
	
	
}
