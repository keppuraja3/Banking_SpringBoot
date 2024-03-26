package com.banking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Customer;
import com.banking.repository.CustomerRepository;
import com.banking.service.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired 
	CustomerService custService;

	
	@PostMapping("/add")
	public Customer add(@RequestBody Customer customer) {
		
		Customer c = custService.addCustomer(customer);
		return c;
	
	}
	
	@GetMapping("/view")
	public List<Customer> viewCustomer(){
		
		List<Customer> customer = custRepo.findAll();
		return customer;
		
	}
	
	@GetMapping("/view/{id}")
	public Optional<Customer> viewCustomerById(@PathVariable int id){
		
		return custRepo.findById(id);
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		custRepo.deleteById(id);
		return "Deleted Successfully";
	}
	
	@PostMapping("/update/{id}")
	public String updateCustomerById(@RequestBody Customer customer,@PathVariable int id)
	{
		Customer c =custRepo.findById(id).get();
		
		c.setBalance(customer.getBalance());
		c.setAccNo(customer.getAccNo());
		
		custRepo.save(c);
		
		return "Updated Successfully";
	}
	
}







