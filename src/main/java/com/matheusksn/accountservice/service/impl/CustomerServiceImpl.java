package com.matheusksn.accountservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.matheusksn.accountservice.repository.CustomerRepository;
import com.matheusksn.accountservice.service.CustomerService;


public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository repository;
	
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}
	
	
}
