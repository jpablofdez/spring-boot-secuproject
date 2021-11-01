package com.security.jwt.controllers;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.exceptions.ResourceNotFoundException;
import com.security.jwt.models.Category;
import com.security.jwt.models.Employee;
import com.security.jwt.models.Expense;
import com.security.jwt.models.ni_team;
import com.security.jwt.repository.CategoryRepository;
import com.security.jwt.repository.ExpenseRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/expenses")
	List<Expense> getExpenses(){
		List<Expense> ex = new ArrayList<Expense>();
		ex = expenseRepository.findAll();
		return expenseRepository.findAll();
	}
	// create employee rest api
	
	@PostMapping("/expenses")
	public Expense createExpense(@RequestBody Expense expense) {
		return expenseRepository.save(expense);
	}
	
	
	
	// get expenses by id rest api
	@GetMapping("/expenses/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
		Expense expense = expenseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(expense);
	}
		
	@PutMapping("/expenses/{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expenses){
		Expense exp = expenseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Expense not exist with id :" + id));
		Category cat = new Category();
		ni_team nt = new ni_team();
		
		exp.setDescription(expenses.getDescription());
		exp.setExpensedate(expenses.getExpensedate());
		exp.setLocation(expenses.getLocation());
		exp.setCategory(expenses.getCategory());
		exp.setTeam(expenses.getTeam());
		
		Expense updatedExpense = expenseRepository.save(exp);
		return ResponseEntity.ok(updatedExpense);
	}
	
	@DeleteMapping("/expenses/{id}")
	ResponseEntity<?>  deleteExpense(@PathVariable Long id){
		expenseRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	

}