package com.arthurlevi.payroll.feignclients;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arthurlevi.payroll.entities.Worker;


@Component
@FeignClient(name = "hr-worker", url = "localhost:8001",path = "/worker")
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable UUID id);

}
