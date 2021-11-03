package com.security.jwt.service;

import java.util.List;
import java.util.Optional;

import com.security.jwt.models.Expense;

public interface ExpenseService {
	public List<Expense> getExpenses();
	public Expense createExpense(Expense expense);

	public void deleteExpense(Long id);
}
