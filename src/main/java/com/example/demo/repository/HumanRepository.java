package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Human;

public interface HumanRepository extends JpaRepository<Human, Integer> {

}
