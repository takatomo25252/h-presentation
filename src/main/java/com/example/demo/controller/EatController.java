package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Eat;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.EatRepository;

@Controller
public class EatController {

	@Autowired
	private EatRepository eatRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping("/eat")
	public String index(Model m) {
	List<Eat> eats = eatRepository.findAll();
		
		//Modelクラスに設定
		m.addAttribute("eats", eats);
		
		return "eat" ;
	}
	
	
	@GetMapping("/eats/{id}/kutuikomi")
	public String edit(
			@PathVariable(name="id", required=false) Integer id,
			Model m
	) {
		Comments comments = null;
		
		
		Optional<Comments> record = commentRepository.findById(id);
		
		if (record.isEmpty() == false) {
			comments = record.get();
		}
		
		//商品が存在しなければ商品一覧へ
		if (comments == null) {
			return "redirect:/eat";
		}
		
		//Modelクラスに設定
		m.addAttribute("comments", comments);
		
		//商品編集画面表示へ
		return "kutikomi";
	}
	
	
	
	
			
		
	
	
	
}
