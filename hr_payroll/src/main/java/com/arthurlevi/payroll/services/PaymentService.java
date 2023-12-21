package com.arthurlevi.payroll.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurlevi.payroll.entities.Payment;
import com.arthurlevi.payroll.entities.Worker;
import com.arthurlevi.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(UUID idWorker, Integer days) {
		
		Worker worker = workerFeignClient.findById(idWorker).getBody();
		return new Payment(worker.getName(),days,worker.getDailyIncome());
	}

}
