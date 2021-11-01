package com.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jwt.models.Expense;


public interface ExpenseRepository extends JpaRepository<Expense,Long> {
	
}