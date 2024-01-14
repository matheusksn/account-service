package com.matheusksn.accountservice.service.impl;

import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusksn.accountservice.dto.CustomerDto;
import com.matheusksn.accountservice.dto.CustomerResponseDto;
import com.matheusksn.accountservice.entity.Customer;
import com.matheusksn.accountservice.repository.CustomerRepository;
import com.matheusksn.accountservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository repository;
	private final ModelMapper mapper;
	private final Random random;
	
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
		this.mapper = new ModelMapper();
		this.random = new Random();
		
	}
	
	@Override
	public CustomerResponseDto saveNewCustomer(CustomerDto customerDto) {
		Customer newCostumer = mapper.map(customerDto, Customer.class);
		newCostumer.setEnable(true);
			
		return mapper.map(repository.save(newCostumer), CustomerResponseDto.class);
	}
	
	@Override
	public CustomerResponseDto findCostumer(String account) {
		Optional<Customer> response = repository.findByAccountNumber(account);
		
		if(!response.isPresent()) {
			throw new RuntimeException(String.format("A conta %s não é válida", account));
		}
		return mapper.map(response.get(), CustomerResponseDto.class);
	}
	
	
}
