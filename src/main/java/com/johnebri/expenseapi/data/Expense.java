package com.johnebri.expenseapi.data;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private Date dateOfExpense;
	@Column(nullable = false)
	@DecimalMin(value = "1", message = "Expense value must not be less than 1.0")
	private Double valueOfExpense;
	@NotEmpty
	@Size(min = 6, message = "Reason of expense must have at least 6 characters.")
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
