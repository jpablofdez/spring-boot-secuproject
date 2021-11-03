package com.security.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.jwt.models.Employee;
import com.security.jwt.models.Expense;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee getById(Long id);
}