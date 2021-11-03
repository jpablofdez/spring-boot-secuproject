package com.security.jwt.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.security.jwt.models.Category;
import com.security.jwt.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	@Override
	public Collection<Category> categories(){
	return categoryRepository.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	@Override
	public void deleteCat(Long id) {
		categoryRepository.deleteById(id);
	}
	
	
}
