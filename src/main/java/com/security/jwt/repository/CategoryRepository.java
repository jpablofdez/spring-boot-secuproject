package com.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jwt.models.Category;



public interface CategoryRepository  extends JpaRepository<Category, Long>{
	Category findByName(String name);
}