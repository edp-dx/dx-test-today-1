package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.SubTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.SubTypesRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sub-types")
public class SubTypesController {

    @Autowired
    private SubTypesRepository repository;

    @GetMapping
    public List<SubTypes> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubTypes> findById(@PathVariable UUID id) {
        Optional<SubTypes> subType = repository.findById(id);
        return subType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SubTypes save(@RequestBody SubTypes subType) {
        return repository.save(subType);
    }

    @PutMapping
    public SubTypes update(@RequestBody SubTypes subType) {
        return repository.save(subType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
