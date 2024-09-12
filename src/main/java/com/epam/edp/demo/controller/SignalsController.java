package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.Signals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.SignalsRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signals")
public class SignalsController {

    @Autowired
    private SignalsRepository repository;

    @GetMapping
    public List<Signals> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signals> findById(@PathVariable UUID id) {
        Optional<Signals> signal = repository.findById(id);
        return signal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Signals save(@RequestBody Signals signal) {
        return repository.save(signal);
    }

    @PutMapping
    public Signals update(@RequestBody Signals signal) {
        return repository.save(signal);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
