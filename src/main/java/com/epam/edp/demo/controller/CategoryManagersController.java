package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.CategoryManagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.CategoryManagersRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category-managers")
public class CategoryManagersController {

    @Autowired
    private CategoryManagersRepository repository;

    @GetMapping
    public List<CategoryManagers> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryManagers> findById(@PathVariable UUID id) {
        Optional<CategoryManagers> categoryManager = repository.findById(id);
        return categoryManager.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryManagers save(@RequestBody CategoryManagers categoryManager) {
        return repository.save(categoryManager);
    }

    @PutMapping
    public CategoryManagers update(@RequestBody CategoryManagers categoryManager) {
        return repository.save(categoryManager);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
