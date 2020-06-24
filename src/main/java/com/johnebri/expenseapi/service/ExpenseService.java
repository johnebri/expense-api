package com.johnebri.expenseapi.service;

import java.util.List;
import java.util.Optional;

import com.johnebri.expenseapi.data.Expense;

public interface ExpenseService {

	List<Expense> getAllExpenses();

	Optional<Expense> getAnExpense(int expenseId);

	Expense createAnExpense(Expense newExpense);

	Expense updateAnExpense(int expenseId, Expense expenseUpdate);

	void deleteAnExpense(int expenseId);

}
