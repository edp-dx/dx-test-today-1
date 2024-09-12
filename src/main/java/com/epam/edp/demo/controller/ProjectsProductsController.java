package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ProjectsProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ProjectsProductsRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects-products")
public class ProjectsProductsController {

    @Autowired
    private ProjectsProductsRepository repository;

    @GetMapping
    public List<ProjectsProducts> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{projectId}/{productId}")
    public ResponseEntity<ProjectsProducts> findById(@PathVariable UUID projectId, @PathVariable UUID productId) {
        Optional<ProjectsProducts> projectsProducts = repository.findById(projectId, productId);
        return projectsProducts.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProjectsProducts save(@RequestBody ProjectsProducts projectsProducts) {
        return repository.save(projectsProducts);
    }

    @PutMapping
    public ProjectsProducts update(@RequestBody ProjectsProducts projectsProducts) {
        return repository.save(projectsProducts);
    }

    @DeleteMapping("/{projectId}/{productId}")
    public void deleteById(@PathVariable UUID projectId, @PathVariable UUID productId) {
        repository.deleteById(projectId, productId);
    }
}
