package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ProjectSubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ProjectSubTypeRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project-sub-type")
public class ProjectSubTypeController {

    @Autowired
    private ProjectSubTypeRepository repository;

    @GetMapping
    public List<ProjectSubType> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectSubType> findById(@PathVariable UUID id) {
        Optional<ProjectSubType> projectSubType = repository.findById(id);
        return projectSubType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProjectSubType save(@RequestBody ProjectSubType projectSubType) {
        return repository.save(projectSubType);
    }

    @PutMapping
    public ProjectSubType update(@RequestBody ProjectSubType projectSubType) {
        return repository.save(projectSubType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
