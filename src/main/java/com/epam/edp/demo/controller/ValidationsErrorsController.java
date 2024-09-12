package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ValidationsErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ValidationsErrorsRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/validations-errors")
public class ValidationsErrorsController {

    @Autowired
    private ValidationsErrorsRepository repository;

    @GetMapping
    public List<ValidationsErrors> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{projectCode}/{supplierId}/{productId}/{errorCode}")
    public ResponseEntity<ValidationsErrors> findById(@PathVariable UUID projectCode, @PathVariable UUID supplierId, @PathVariable UUID productId, @PathVariable UUID errorCode) {
        Optional<ValidationsErrors> validationsErrors = repository.findById(projectCode, supplierId, productId, errorCode);
        return validationsErrors.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ValidationsErrors save(@RequestBody ValidationsErrors validationsErrors) {
        return repository.save(validationsErrors);
    }

    @PutMapping
    public ValidationsErrors update(@RequestBody ValidationsErrors validationsErrors) {
        return repository.save(validationsErrors);
    }

    @DeleteMapping("/{projectCode}/{supplierId}/{productId}/{errorCode}")
    public void deleteById(@PathVariable UUID projectCode, @PathVariable UUID supplierId, @PathVariable UUID productId, @PathVariable UUID errorCode) {
        repository.deleteById(projectCode, supplierId, productId, errorCode);
    }
}
