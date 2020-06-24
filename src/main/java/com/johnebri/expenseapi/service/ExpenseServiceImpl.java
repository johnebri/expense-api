package com.johnebri.expenseapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnebri.expenseapi.dao.ExpenseRepository;
import com.johnebri.expenseapi.data.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepo;

	@Autowired
	public ExpenseServiceImpl(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public Expense getAnExpense(int expenseId) {
		return expenseRepo.findExpenseById(expenseId);
	}

	@Override
	public Expense createAnExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}

	@Override
	public Expense updateAnExpense(int expenseId, Expense expenseUpdate) {
		expenseUpdate.setId(expenseId);
		return expenseRepo.save(expenseUpdate);
	}

	@Override
	public void deleteAnExpense(int expenseId) {		
		expenseRepo.deleteById(expenseId);
	}

}
