package com.johnebri.expenseapi.service;

import java.util.List;

import com.johnebri.expenseapi.data.Expense;

public interface ExpenseService {

	List<Expense> getAllExpenses();

	Expense getAnExpense(int expenseId);

	Expense createAnExpense(Expense newExpense);

	Expense updateAnExpense(int expenseId, Expense expenseUpdate);

	void deleteAnExpense(int expenseId);

}
