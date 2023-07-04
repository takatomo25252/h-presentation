package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Human;

public interface HumanRepository extends JpaRepository<Human, Integer> {

	List<Human> findByBango(Integer bango);
	Optional<Human> findByBangoAndPassword(Integer bango, String password);

	
}
