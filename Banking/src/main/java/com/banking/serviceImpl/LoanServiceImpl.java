package com.banking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.banking.entity.Loan;
import com.banking.repository.LoanRepository;
import com.banking.service.LoanService;
@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	LoanRepository LoanRepo;
	
	public Loan createLoan(Loan l) {
		Loan LoanSer=LoanRepo.save(l);
		return LoanSer;
	}
	
	public List<Loan> viewLoan()
	{
		List<Loan>listLoan=LoanRepo.findAll();
		
		return listLoan;
	}
	
	public Loan viewLoanById(int id) {
		
		return LoanRepo.findById(id).get();
		
	}
	
	public String deleteById(int id) {
		
		LoanRepo.deleteById(id);
		
		return "Deleted Successfully";
		
	}
	
	public Loan updateById(@RequestBody Loan loan, @PathVariable int id) {
		
		Loan u =LoanRepo.findById(id).get();
		
		u.setName(loan.getName());
		u.setAddress(loan.getAddress());
		u.setAmount(loan.getAmount());
		
		LoanRepo.save(u);
		
		return u;
		
	}
	
	
}





