package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ErrorLanguages2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ErrorLanguages2Repository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/error-languages2")
public class ErrorLanguages2Controller {

    @Autowired
    private ErrorLanguages2Repository repository;

    @GetMapping
    public List<ErrorLanguages2> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ErrorLanguages2> findById(@PathVariable UUID id) {
        Optional<ErrorLanguages2> errorLanguage = repository.findById(id);
        return errorLanguage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ErrorLanguages2 save(@RequestBody ErrorLanguages2 errorLanguage) {
        return repository.save(errorLanguage);
    }

    @PutMapping
    public ErrorLanguages2 update(@RequestBody ErrorLanguages2 errorLanguage) {
        return repository.save(errorLanguage);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
