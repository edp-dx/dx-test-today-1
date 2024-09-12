package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ErrorMessages1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ErrorMessages1Repository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/error-messages1")
public class ErrorMessages1Controller {

    @Autowired
    private ErrorMessages1Repository repository;

    @GetMapping
    public List<ErrorMessages1> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{errorCode}")
    public ResponseEntity<ErrorMessages1> findById(@PathVariable UUID errorCode) {
        Optional<ErrorMessages1> errorMessage = repository.findById(errorCode);
        return errorMessage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ErrorMessages1 save(@RequestBody ErrorMessages1 errorMessage) {
        return repository.save(errorMessage);
    }

    @PutMapping
    public ErrorMessages1 update(@RequestBody ErrorMessages1 errorMessage) {
        return repository.save(errorMessage);
    }

    @DeleteMapping("/{errorCode}")
    public void deleteById(@PathVariable UUID errorCode) {
        repository.deleteById(errorCode);
    }
}
