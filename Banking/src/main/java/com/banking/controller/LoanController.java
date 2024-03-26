package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Loan;
//import com.banking.repository.LoanRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import com.banking.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	LoanService LoanServ;
	
//	create a new loan member to database
	@PostMapping("/create")
	public Loan create(@RequestBody Loan loan) {
		
		Loan l = LoanServ.createLoan(loan);
		
		return l;
		
	}
	
//	View all member in loan database
	@GetMapping("/view")
	public List<Loan> view() {
		
		return LoanServ.viewLoan();
		
	}
	
	// view member list using id
	
	@GetMapping("/view/{id}")
	public Loan viewLoanById(@PathVariable int id) {
	
		return LoanServ.viewLoanById(id);
	}
	
	
	//Update 
	
	@PostMapping("/update/{id}")
	
	public Loan updateLoan(@RequestBody Loan loan, @PathVariable int id) {
		
		
		Loan update = LoanServ.updataById(loan,id);
		
		return update;
	
	}
	
	@PostMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		
		LoanServ.deleteById(id);	
		
		return "Deleted Successfully";
	}
	
	
}






