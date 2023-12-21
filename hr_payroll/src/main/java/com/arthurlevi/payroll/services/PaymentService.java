package com.arthurlevi.payroll.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arthurlevi.payroll.entities.Payment;
import com.arthurlevi.payroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr_worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplete;
	
	public Payment getPayment(UUID idWorker, Integer days) {
		Map<String,String> uriVariable = new HashMap<>();
		uriVariable.put("id", ""+idWorker);
		
		Worker worker = restTemplete.getForObject(workerHost + "/worker/{id}",Worker.class,uriVariable);
		return new Payment(worker.getName(),days,worker.getDailyIncome());
	}

}
