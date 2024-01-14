package com.matheusksn.accountservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusksn.accountservice.dto.CustomerDto;
import com.matheusksn.accountservice.service.CustomerService;

@RestController
@RequestMapping("/customer-account")
public class CustomerAccountController extends BaseController {
	
	private final CustomerService service;
	
	public CustomerAccountController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping()
	public ResponseEntity createAccount(@RequestBody CustomerDto costumerDto) {
		try {
		CustomerDto newCostumer = service.saveNewCustomer(costumerDto);
		return getResponseSuccess(newCostumer, "Conta cadastrada com sucesso", HttpStatus.CREATED);
		}
		catch(Exception error){
			return getResponseError(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);				
		}
	}
	
	@GetMapping("{account}")
	public ResponseEntity isValid(@PathVariable String account) {
		try {	
			return getResponseSuccess(service.findCostumer(account),"Conta Válida", HttpStatus.OK);
			
		}catch(Exception error){
			return getResponseError(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);				
		}
	}
	

}
