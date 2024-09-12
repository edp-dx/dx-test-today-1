package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.SignalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.SignalTypeRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signal-type")
public class SignalTypeController {

    @Autowired
    private SignalTypeRepository repository;

    @GetMapping
    public List<SignalType> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignalType> findById(@PathVariable UUID id) {
        Optional<SignalType> signalType = repository.findById(id);
        return signalType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SignalType save(@RequestBody SignalType signalType) {
        return repository.save(signalType);
    }

    @PutMapping
    public SignalType update(@RequestBody SignalType signalType) {
        return repository.save(signalType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
