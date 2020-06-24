package com.johnebri.expenseapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johnebri.expenseapi.data.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{
	Expense findExpenseById(int id);
}
