package com.security.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.security.jwt.models.Category;
import com.security.jwt.models.Expense;
import com.security.jwt.models.ni_team;
import com.security.jwt.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	
	private ExpenseRepository expenseRepository;
	
	@Override
	public List<Expense> getExpenses(){
		List<Expense> ex = new ArrayList<Expense>();
		return expenseRepository.findAll();
	}
	
	@Override
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	
	@Override
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	
}
