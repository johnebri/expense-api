package com.johnebri.expenseapi.controller;

import java.util.List;

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
import com.johnebri.expenseapi.service.UtilService;

@RestController
@RequestMapping("api/v1/expense")
public class ExpenseController {

	private final ExpenseServiceImpl expenseSvc;
	private final UtilService utilSvc;

	// inject Expense Service and Utility Service into Expense Controller
	@Autowired
	public ExpenseController(ExpenseServiceImpl expenseSvc, UtilService utilSvc) {
		this.expenseSvc = expenseSvc;
		this.utilSvc = utilSvc;
	}

	// get all expenses
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {
		List<Expense> newExpense = expenseSvc.getAllExpenses();
		return new ResponseEntity<List<Expense>>(newExpense, HttpStatus.OK);
	}

	// get an expense
	@GetMapping("{expenseId}")
	public Expense getAnExpense(@PathVariable("expenseId") int expenseId) {
		
		// check if expense exists
		utilSvc.checkIfExpenseExists(expenseId);
		
		return expenseSvc.getAnExpense(expenseId);
	}

	// create an expense
	@PostMapping
	public ResponseEntity<Expense> createAnExpense(@Valid @RequestBody Expense expense) {
		Expense newExpense = expenseSvc.createAnExpense(expense);
		return new ResponseEntity<Expense>(newExpense, HttpStatus.CREATED);
	}

	// update an expense
	@PutMapping("{expenseId}")
	public ResponseEntity<Expense> updateAnExpense(@PathVariable("expenseId") int expenseId,
			@Valid @RequestBody Expense expense) {

		// check if expense exists
		utilSvc.checkIfExpenseExists(expenseId);

		// get the expense
		Expense retrievedExp = expenseSvc.getAnExpense(expenseId);
		expense.setDateTimeCreated(retrievedExp.getDateTimeCreated());

		// update the expense
		Expense updatedExpense = expenseSvc.updateAnExpense(expenseId, expense);
		return new ResponseEntity<Expense>(updatedExpense, HttpStatus.OK);
	}

	// delete an expense
	@DeleteMapping("{expenseId}")
	public ResponseEntity<String> deleteAnExpense(@PathVariable("expenseId") int expenseId) {

		// check if expense exists
		utilSvc.checkIfExpenseExists(expenseId);

		expenseSvc.deleteAnExpense(expenseId);
		return new ResponseEntity<String>("Expense Deleted", HttpStatus.OK);
	}

}
