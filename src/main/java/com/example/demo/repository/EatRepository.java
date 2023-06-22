package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Eat;

public interface EatRepository extends JpaRepository<Eat, Integer> {

}
