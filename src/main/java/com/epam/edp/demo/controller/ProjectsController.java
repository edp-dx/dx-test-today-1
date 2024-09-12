package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ProjectsRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectsController {

    @Autowired
    private ProjectsRepository repository;

    @GetMapping
    public List<Projects> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Projects> findById(@PathVariable UUID code) {
        Optional<Projects> project = repository.findById(code);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Projects save(@RequestBody Projects project) {
        return repository.save(project);
    }

    @PutMapping
    public Projects update(@RequestBody Projects project) {
        return repository.save(project);
    }

    @DeleteMapping("/{code}")
    public void deleteById(@PathVariable UUID code) {
        repository.deleteById(code);
    }
}
