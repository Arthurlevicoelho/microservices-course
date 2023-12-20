package com.arthurlevi.payroll.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.arthurlevi.payroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(UUID idWorker, Integer days) {
		return new Payment("Bob",days,200.0);
	}

}
