package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

	@Transient
	private Integer eatid;
	
	@OneToOne
	@JoinColumn(name="eatid")
	private Eat eat;
	
	public Comments() {

	}

	//コンストラクタ（登録用）
	public Comments(Integer eatid, Integer bango, String namae, String comment) {
		this.comment = comment;
		this.bango = bango;
		this.namae = namae;
		this.eatid = eatid;
	}

}
