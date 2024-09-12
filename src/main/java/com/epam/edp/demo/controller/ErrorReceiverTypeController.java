package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ErrorReceiverType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ErrorReceiverTypeRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/error-receiver-type")
public class ErrorReceiverTypeController {

    @Autowired
    private ErrorReceiverTypeRepository repository;

    @GetMapping
    public List<ErrorReceiverType> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ErrorReceiverType> findById(@PathVariable UUID id) {
        Optional<ErrorReceiverType> errorReceiverType = repository.findById(id);
        return errorReceiverType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ErrorReceiverType save(@RequestBody ErrorReceiverType errorReceiverType) {
        return repository.save(errorReceiverType);
    }

    @PutMapping
    public ErrorReceiverType update(@RequestBody ErrorReceiverType errorReceiverType) {
        return repository.save(errorReceiverType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
