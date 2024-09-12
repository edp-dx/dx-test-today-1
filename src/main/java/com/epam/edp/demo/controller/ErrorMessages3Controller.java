package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ErrorMessages3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ErrorMessages3Repository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/error-messages3")
public class ErrorMessages3Controller {

    @Autowired
    private ErrorMessages3Repository repository;

    @GetMapping
    public List<ErrorMessages3> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{errorCode}")
    public ResponseEntity<ErrorMessages3> findById(@PathVariable UUID errorCode) {
        Optional<ErrorMessages3> errorMessage = repository.findById(errorCode);
        return errorMessage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ErrorMessages3 save(@RequestBody ErrorMessages3 errorMessage) {
        return repository.save(errorMessage);
    }

    @PutMapping
    public ErrorMessages3 update(@RequestBody ErrorMessages3 errorMessage) {
        return repository.save(errorMessage);
    }

    @DeleteMapping("/{errorCode}")
    public void deleteById(@PathVariable UUID errorCode) {
        repository.deleteById(errorCode);
    }
}
