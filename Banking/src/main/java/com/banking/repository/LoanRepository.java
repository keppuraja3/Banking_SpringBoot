package com.banking.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banking.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

	@Query("Select l FROM Loan l where l.id=6")
	Collection<Loan> viewLoanById();


}

