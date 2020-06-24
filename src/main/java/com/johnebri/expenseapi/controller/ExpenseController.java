package com.johnebri.expenseapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/expense")
public class ExpenseController {

	@GetMapping
	public String getAllExpenses() {
		return "Welcome";
	}

	@GetMapping("{expenseId}")
	public String getAnExpense(@PathVariable("expenseId") int expenseId) {
		return "get an expense : " + expenseId;
	}

}
