package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer bango;

	private String namae;
	private String comment;

	private Integer eatid;



public Comments() {

}

//コンストラクタ（登録用）
public Comments(Integer eatid, Integer bango, String namae,String comment) {
	this.comment = comment;
	this.bango=bango;
	this.namae=namae;
	this.eatid=eatid;
	

}

}


