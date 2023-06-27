package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer> {
	
//	List<Comments> findByEatid(Integer eatid);
	@Query(value="select * from comments where eatid=:eatid" ,nativeQuery = true)
	List<Comments> findByEat(Integer eatid);

}
