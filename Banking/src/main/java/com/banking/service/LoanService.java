package com.banking.service;

import java.util.List;

import com.banking.entity.Loan;

public interface LoanService {

	Loan createLoan(Loan l);
	
	List<Loan> viewLoan();
	
	Loan viewLoanById(int id);
	
	String deleteById(int id);
	
	Loan updataById(Loan l,int id);
	
}
