package com.johnebri.expenseapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnebri.expenseapi.data.Expense;
import com.johnebri.expenseapi.service.ExpenseServiceImpl;

@RestController
@RequestMapping("api/v1/expense")
public class ExpenseController {

	private final ExpenseServiceImpl expenseSvc;

	@Autowired
	public ExpenseController(ExpenseServiceImpl expenseSvc) {
		this.expenseSvc = expenseSvc;
	}

	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {
		List<Expense> newExpense = expenseSvc.getAllExpenses();
		return new ResponseEntity<List<Expense>>(newExpense, HttpStatus.OK);
	}

	@GetMapping("{expenseId}")
	public Optional<Expense> getAnExpense(@PathVariable("expenseId") int expenseId) {
		return expenseSvc.getAnExpense(expenseId);
	}

	@PostMapping
	public ResponseEntity<Expense> createAnExpense(@Valid @RequestBody Expense expense) {
		Expense newExpense = expenseSvc.createAnExpense(expense);
		return new ResponseEntity<Expense>(newExpense, HttpStatus.CREATED);
	}

	@PutMapping("{expenseId}")
	public ResponseEntity<Expense> updateAnExpense(@Valid @PathVariable("expenseId") int expenseId,
			@RequestBody Expense expense) {
		Expense updatedExpense = expenseSvc.updateAnExpense(expenseId, expense);
		return new ResponseEntity<Expense>(updatedExpense, HttpStatus.OK);
	}
	
	@DeleteMapping("{expenseId}")
	public ResponseEntity<String> deleteAnExpense(@PathVariable("expenseId") int expenseId) {
		expenseSvc.deleteAnExpense(expenseId);
		return new ResponseEntity<String>("Expense Deleted", HttpStatus.OK);
	}

}
