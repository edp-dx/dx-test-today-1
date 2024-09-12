package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.MainTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.MainTypesRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/main-types")
public class MainTypesController {

    @Autowired
    private MainTypesRepository repository;

    @GetMapping
    public List<MainTypes> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MainTypes> findById(@PathVariable UUID id) {
        Optional<MainTypes> mainType = repository.findById(id);
        return mainType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MainTypes save(@RequestBody MainTypes mainType) {
        return repository.save(mainType);
    }

    @PutMapping
    public MainTypes update(@RequestBody MainTypes mainType) {
        return repository.save(mainType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
