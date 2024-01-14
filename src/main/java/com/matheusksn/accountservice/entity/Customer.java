package com.matheusksn.accountservice.entity;

import java.util.Random;

import javax.persistence.*;
import lombok.Data;

@Entity(name= "CUSTOMER")
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "account_number",nullable = false, unique= true)
	private String accountNumber;
	
	@Column(nullable = false, unique= true, length = 11)
	private String cpf;
	
	@Column(name="full_name", nullable = false, length = 100)
	private String fullName;
	
	@Column(nullable= false)
	private boolean enable;
	
	@Column
	private String nickname;
	

    @PrePersist
    private void generateAccountNumber() {
        if (accountNumber == null || accountNumber.isEmpty()) {
            accountNumber = generateRandomAccountNumber();
        }
    }

    private String generateRandomAccountNumber() {

        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            accountNumber.append(random.nextInt(10));
        }

        return accountNumber.toString();
    }

}
