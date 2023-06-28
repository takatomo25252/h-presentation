package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String index(
			@RequestParam(name="area" ,required=false) String area , 
			@RequestParam(name="genre" ,required=false) String genre
			,Model m) {
	List<Eat> eats =null;
	
		
			if(area==null&&genre==null) {
				eats=eatRepository.findAll();
			}else if(area.equals("ikebukuro")) {
				eats=eatRepository.findByArea(area);
			}else if(area.equals("ichigaya")) {
				eats=eatRepository.findByArea(area);
			}else if(area.equals("shinjuku")) {
				eats=eatRepository.findByArea(area);
			}
			
			else if(genre.equals("wa")) {
				eats=eatRepository.findByGenre(genre);
			}else if(genre.equals("you")) {
				eats=eatRepository.findByGenre(genre);
			}else if(genre.equals("tyu")) {
				eats=eatRepository.findByGenre(genre);
			}else if(genre.equals("sonota")) {
				eats=eatRepository.findByGenre(genre);
			}
		//Modelクラスに設定
	
		m.addAttribute("eats", eats);
		
		return "eat" ;
	}
	
	
	@GetMapping("kutikomi")
	public String edit(
			/*@RequestParam(name="id", required=false) Integer id,*/
			@RequestParam(name="eatid", required=false) Integer eatid,
			Model m
	) {
		
		 List<Comments> comments = null;
				
		comments =commentRepository.findByEat(eatid);
		
		/*	Comments comments = null;
			Optional<Comments> record = commentRepository.findById(id);
			
			if (record.isEmpty() == false) {
				comments = record.get();
			}*/
		m.addAttribute("comments", comments);
		
		//商品編集画面表示へ
		return "kutikomi";
	}
	
	
	
	
			
		
	
	
	
}
