package com.example.demo.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data

@Component
@SessionScope
public class Human {
	//フィールド
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
	

	
}
