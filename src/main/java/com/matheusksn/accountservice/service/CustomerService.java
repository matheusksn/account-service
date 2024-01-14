package com.matheusksn.accountservice.service;

import com.matheusksn.accountservice.dto.CustomerDto;
import com.matheusksn.accountservice.dto.CustomerResponseDto;

public interface CustomerService {

	CustomerResponseDto saveNewCustomer(CustomerDto customerDto);

	CustomerResponseDto findCostumer(String account);

}
