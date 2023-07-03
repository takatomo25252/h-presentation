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
	
	/*@Autowired
	private HumanRepository humanRepository;*/
	
	@GetMapping("/eat")
	public String index(
			@RequestParam(name="area" ,required=false) String area , 
			@RequestParam(name="genre" ,required=false) String genre,
			
			Model m) {
	List<Eat> eats =null;
	
		
			if(area==null&&genre==null) {
				eats=eatRepository.findAll();
			} 
			
			else if(area!=null&&genre==null) {
				eats=eatRepository.findByArea(area);}
			else if(area==null&&genre!=null) {
				eats=eatRepository.findByGenre(genre);}
			
		
	
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
		m.addAttribute("shopname", comments.get(0).getEat().getName());
		m.addAttribute("shoparea", comments.get(0).getEat().getArea());
		m.addAttribute("shopgenre", comments.get(0).getEat().getGenre());
		m.addAttribute("shopdetail", comments.get(0).getEat().getDetail());
		m.addAttribute("shopstar", comments.get(0).getEat().getStar());
		m.addAttribute("shoplink", comments.get(0).getEat().getLink());
		
		//商品編集画面表示へ
		return "kutikomi";
	}
	
	
	
	
			
		
	
	
	
}
