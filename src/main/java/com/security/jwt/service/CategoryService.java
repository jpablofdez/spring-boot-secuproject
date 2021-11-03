package com.security.jwt.service;

import java.util.Collection;
import java.util.Optional;

import com.security.jwt.models.Category;

public interface CategoryService {
	
	public Collection<Category> categories();

	public Category saveCategory(Category category);
	public void deleteCat(Long id);
}
