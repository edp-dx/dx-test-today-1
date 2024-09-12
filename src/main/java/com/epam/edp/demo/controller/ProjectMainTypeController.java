package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ProjectMainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ProjectMainTypeRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project-main-type")
public class ProjectMainTypeController {

    @Autowired
    private ProjectMainTypeRepository repository;

    @GetMapping
    public List<ProjectMainType> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectMainType> findById(@PathVariable UUID id) {
        Optional<ProjectMainType> projectMainType = repository.findById(id);
        return projectMainType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProjectMainType save(@RequestBody ProjectMainType projectMainType) {
        return repository.save(projectMainType);
    }

    @PutMapping
    public ProjectMainType update(@RequestBody ProjectMainType projectMainType) {
        return repository.save(projectMainType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
