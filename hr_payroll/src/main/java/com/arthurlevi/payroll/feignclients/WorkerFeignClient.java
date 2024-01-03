package com.arthurlevi.payroll.feignclients;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arthurlevi.payroll.entities.Worker;


@FeignClient(name = "hr-worker",path = "/worker")
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable UUID id);
}
