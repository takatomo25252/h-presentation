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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bango;

	
	private String namae;
	private String comment;

    private Integer id;
	private String name;

	
}
