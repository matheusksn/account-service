package com.matheusksn.accountservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusksn.accountservice.entity.Customer;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional <Customer> findByAccountNumber(String accountNumber);
	
}
