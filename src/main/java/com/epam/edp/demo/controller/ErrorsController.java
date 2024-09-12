package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ErrorsRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/errors")
public class ErrorsController {

    @Autowired
    private ErrorsRepository repository;

    @GetMapping
    public List<Errors> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Errors> findById(@PathVariable UUID code) {
        Optional<Errors> error = repository.findById(code);
        return error.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Errors save(@RequestBody Errors error) {
        return repository.save(error);
    }

    @PutMapping
    public Errors update(@RequestBody Errors error) {
        return repository.save(error);
    }

    @DeleteMapping("/{code}")
    public void deleteById(@PathVariable UUID code) {
        repository.deleteById(code);
    }
}
