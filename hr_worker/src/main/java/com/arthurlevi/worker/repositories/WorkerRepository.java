package com.arthurlevi.worker.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurlevi.worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker,UUID>{

	Worker findByName(String name);
}
