package com.johnebri.expenseapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.johnebri.expenseapi.dao.ExpenseRepository;

@Service
public class UtilService {

	@Autowired
	ExpenseRepository expenseRepo;

	public void checkIfExpenseExists(int expenseId) {
		
		if (!expenseRepo.findById(expenseId).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Expense ID %s Not Found", expenseId));
		}
	}

}
