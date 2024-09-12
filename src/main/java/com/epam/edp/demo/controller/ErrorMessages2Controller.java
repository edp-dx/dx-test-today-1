package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ErrorMessages2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ErrorMessages2Repository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/error-messages2")
public class ErrorMessages2Controller {

    @Autowired
    private ErrorMessages2Repository repository;

    @GetMapping
    public List<ErrorMessages2> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ErrorMessages2> findById(@PathVariable UUID id) {
        Optional<ErrorMessages2> errorMessage = repository.findById(id);
        return errorMessage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ErrorMessages2 save(@RequestBody ErrorMessages2 errorMessage) {
        return repository.save(errorMessage);
    }

    @PutMapping
    public ErrorMessages2 update(@RequestBody ErrorMessages2 errorMessage) {
        return repository.save(errorMessage);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
