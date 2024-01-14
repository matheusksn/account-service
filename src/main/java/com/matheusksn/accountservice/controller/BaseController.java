package com.matheusksn.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.matheusksn.accountservice.dto.ResponseDto;

public class BaseController {
	
	@Autowired
	private Environment environment;
	
	private String getPort() {
		return environment.getProperty("server.port");
	}
	
	protected ResponseEntity getResponseError(String message, HttpStatus status) {
		return new ResponseEntity(ResponseDto.builder()
				.port(getPort())
				.message(message)
				.build(), status);
	}
	
	protected ResponseEntity getResponseSuccess(Object data, String message, HttpStatus status) {
		return new ResponseEntity(ResponseDto.builder()
				.port(getPort())
				.message(message)
				.data(data)
				.build(), status);
	}
	
	
	

}
