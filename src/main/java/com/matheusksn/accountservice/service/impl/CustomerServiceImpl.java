package com.matheusksn.accountservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.matheusksn.accountservice.dto.CustomerDto;
import com.matheusksn.accountservice.entity.Customer;
import com.matheusksn.accountservice.repository.CustomerRepository;
import com.matheusksn.accountservice.service.CustomerService;


public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository repository;
	private final ModelMapper mapper;
	
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
		this.mapper = new ModelMapper();
	}
	
	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		Customer newCostumer =mapper.map(customerDto, Customer.class);
		newCostumer.setEnable(true);
		newCostumer.setAccountNumber("1234");
		
		repository.save(newCostumer);
		
		return customerDto;
	}
	
	
}
