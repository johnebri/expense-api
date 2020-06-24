package com.johnebri.expenseapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.johnebri.expenseapi.dao.ExpenseRepository;
import com.johnebri.expenseapi.data.Expense;
import com.johnebri.expenseapi.service.ExpenseServiceImpl;

@SpringBootTest
class ExpenseapiApplicationTests {

	@Autowired
	private ExpenseServiceImpl expenseSvc;

	@MockBean
	private ExpenseRepository expenseRepo;

	@Test
	public void getAllExpensesTest() {
		when(expenseRepo.findAll()).thenReturn(Stream.of(new Expense(), new Expense()).collect(Collectors.toList()));
		assertEquals(2, expenseSvc.getAllExpenses().size());
	}

	@Test
	public void getAnExpenseTest() {
		int expenseId = 1;
		Expense newExp = new Expense();
		when(expenseRepo.findExpenseById(expenseId)).thenReturn(newExp);
		assertEquals(newExp, expenseSvc.getAnExpense(expenseId));
	}

	@Test
	public void createAnExpenseTest() {
		Expense expense = new Expense();
		when(expenseRepo.save(expense)).thenReturn(expense);
		assertEquals(expense, expenseSvc.createAnExpense(expense));
	}

	@Test
	public void updateAnExpenseTest() {
		int expenseId = 1;
		Expense expense = new Expense();
		when(expenseRepo.save(expense)).thenReturn(expense);
		assertEquals(expense, expenseSvc.updateAnExpense(expenseId, expense));
	}

	@Test
	public void deleteAnExpenseTest() {
		int expenseId = 1;
		expenseSvc.deleteAnExpense(expenseId);
		verify(expenseRepo, times(1)).deleteById(expenseId);
	}

}
