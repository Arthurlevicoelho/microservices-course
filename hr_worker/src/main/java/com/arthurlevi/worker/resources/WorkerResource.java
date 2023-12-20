package com.arthurlevi.worker.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurlevi.worker.entities.Worker;
import com.arthurlevi.worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/worker")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();

        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable UUID id){
        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody Worker worker){
        var user = repository.findByName(worker.getName());

        if(user != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }
        var userCreated = repository.save(worker);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

}
