package com.banking.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.banking.entity.Customer;

public interface CustomerRepository extends JpaRepositoryImplementation<Customer, Integer>{

}
