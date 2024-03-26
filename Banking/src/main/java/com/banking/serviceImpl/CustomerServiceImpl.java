package com.banking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Customer;
import com.banking.repository.CustomerRepository;
import com.banking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository custRepo;
	
	public Customer addCustomer( Customer cust) {
		
	Customer a = custRepo.save(cust);
		
		return a;
	}
	
}
