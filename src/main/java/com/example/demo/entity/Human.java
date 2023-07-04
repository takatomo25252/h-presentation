package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "human")

public class Human {
	//フィールド
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bango;
	private String namae;
	private String password;

	//コンストラクタ
	public Human() {

	}

	public Human(Integer bango, String namae) {
		this.bango = bango;
		this.namae = namae;
	}

	public Human(Integer bango, String namae, String password) {
		this.bango = bango;
		this.namae = namae;
		this.password = password;
	}
	public Human(String namae) {
		
		this.namae = namae;
	}

}
