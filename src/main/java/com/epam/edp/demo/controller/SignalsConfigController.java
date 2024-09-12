package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.SignalsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.SignalsConfigRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signals-config")
public class SignalsConfigController {

    @Autowired
    private SignalsConfigRepository repository;

    @GetMapping
    public List<SignalsConfig> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignalsConfig> findById(@PathVariable UUID id) {
        Optional<SignalsConfig> signalsConfig = repository.findById(id);
        return signalsConfig.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SignalsConfig save(@RequestBody SignalsConfig signalsConfig) {
        return repository.save(signalsConfig);
    }

    @PutMapping
    public SignalsConfig update(@RequestBody SignalsConfig signalsConfig) {
        return repository.save(signalsConfig);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
