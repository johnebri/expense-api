package com.johnebri.expenseapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnebri.expenseapi.dao.ExpenseRepository;
import com.johnebri.expenseapi.data.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepo;
	private final UtilService utilSvc;

	@Autowired
	public ExpenseServiceImpl(ExpenseRepository expenseRepo, UtilService utilSvc) {
		this.expenseRepo = expenseRepo;
		this.utilSvc = utilSvc;
	}

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public Optional<Expense> getAnExpense(int expenseId) {

		// check if expense exists
		utilSvc.checkIfExpenseExists(expenseId);

		return expenseRepo.findById(expenseId);
	}

	@Override
	public Expense createAnExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}

	@Override
	public Expense updateAnExpense(int expenseId, Expense expenseUpdate) {

		// check if expense exists
		utilSvc.checkIfExpenseExists(expenseId);

		expenseUpdate.setId(expenseId);
		return expenseRepo.save(expenseUpdate);
	}

	@Override
	public void deleteAnExpense(int expenseId) {
		
		// check if expense exists
		utilSvc.checkIfExpenseExists(expenseId);
		
		expenseRepo.deleteById(expenseId);
	}

}
