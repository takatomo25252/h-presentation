package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "eat")
public class Eat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	
	private String name;
	private String area;
	private String genre;
	private String detail;
	private String star;
	private String link;
	private String pic;
	private String inside;
	private String outside;
	private String food;
	
	

	
}
