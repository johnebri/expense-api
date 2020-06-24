package com.johnebri.expenseapi.data;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dateOfExpense;
	private Double valueOfExpense;
	private String reasonOfExpense;
	@CreationTimestamp
	private Timestamp dateTimeCreated;

	public Expense() {
	}

	public Expense(int id, Date dateOfExpense, Double valueOfExpense, String reasonOfExpense,
			Timestamp dateTimeCreated) {
		super();
		this.id = id;
		this.dateOfExpense = dateOfExpense;
		this.valueOfExpense = valueOfExpense;
		this.reasonOfExpense = reasonOfExpense;
		this.dateTimeCreated = dateTimeCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfExpense() {
		return dateOfExpense;
	}

	public void setDateOfExpense(Date dateOfExpense) {
		this.dateOfExpense = dateOfExpense;
	}

	public Double getValueOfExpense() {
		return valueOfExpense;
	}

	public void setValueOfExpense(Double valueOfExpense) {
		this.valueOfExpense = valueOfExpense;
	}

	public String getReasonOfExpense() {
		return reasonOfExpense;
	}

	public void setReasonOfExpense(String reasonOfExpense) {
		this.reasonOfExpense = reasonOfExpense;
	}

	public Timestamp getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setDateTimeCreated(Timestamp dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}
}
