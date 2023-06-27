package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Eat;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.EatRepository;

import jakarta.transaction.Transactional;

@Controller
public class NewCommentController {

	@Autowired
	private EatRepository eatRepository;

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

		Optional<Eat> result = eatRepository.findById(eatid);
		Eat eat = null;
		if (result.isPresent()) {
			eat = result.get();
		}
		Comments comments = new Comments(eat, bango, namae, newcomment);

		commentRepository.save(comments);

		m.addAttribute("comments", comments);

		return "confirm";
	}

	@PostMapping("/update")
	@Transactional
	public String update(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "eatid", required = false) Integer eatid,
			@RequestParam(name = "bango", required = false) Integer bango,
			@RequestParam(name = "namae", required = false) String namae,
			@RequestParam(name = "comment", required = false) String comment,
			Model m) {
		Optional<Eat> result = eatRepository.findById(eatid);
		Eat eat = null;
		if (result.isPresent()) {
			eat = result.get();
		}
		Comments comments = new Comments(eat, bango, namae, comment);

		commentRepository.save(comments);
		m.addAttribute("comments", comments);
		
		

		return "redirect:/eat";
	}

}


