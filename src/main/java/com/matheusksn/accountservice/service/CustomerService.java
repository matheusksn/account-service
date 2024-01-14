package com.matheusksn.accountservice.service;

import org.springframework.stereotype.Service;

import com.matheusksn.accountservice.dto.CustomerDto;

@Service
public interface CustomerService {

	CustomerDto saveNewCustomer(CustomerDto customerDto);

}
