package com.arthurlevi.payroll.services;

import java.util.UUID;

import org.bouncycastle.util.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurlevi.payroll.entities.Payment;
import com.arthurlevi.payroll.entities.Worker;
import com.arthurlevi.payroll.feignclients.WorkerFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PaymentService {

	@Autowired
	WorkerFeignClient workerFeignClient;
	
	@CircuitBreaker(name = "Alternative", fallbackMethod = "PaymentAlternative")
	public Payment getPayment(UUID idWorker, Integer days) {
		
		Worker worker = workerFeignClient.findById(idWorker).getBody();
		return new Payment(worker.getName(),days,worker.getDailyIncome());
	}
	
	public Payment PaymentAlternative(UUID idWorker, Integer days,Exception e) {
		
		return new Payment("Joao",days,400.0);
		
	}

}
