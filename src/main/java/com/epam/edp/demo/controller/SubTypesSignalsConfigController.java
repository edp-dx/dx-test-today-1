package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.SubTypesSignalsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.SubTypesSignalsConfigRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sub-types-signals-config")
public class SubTypesSignalsConfigController {

    @Autowired
    private SubTypesSignalsConfigRepository repository;

    @GetMapping
    public List<SubTypesSignalsConfig> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{subTypeId}/{signalsConfigId}")
    public ResponseEntity<SubTypesSignalsConfig> findById(@PathVariable UUID subTypeId, @PathVariable UUID signalsConfigId) {
        Optional<SubTypesSignalsConfig> subTypesSignalsConfig = repository.findById(subTypeId, signalsConfigId);
        return subTypesSignalsConfig.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SubTypesSignalsConfig save(@RequestBody SubTypesSignalsConfig subTypesSignalsConfig) {
        return repository.save(subTypesSignalsConfig);
    }

    @PutMapping
    public SubTypesSignalsConfig update(@RequestBody SubTypesSignalsConfig subTypesSignalsConfig) {
        return repository.save(subTypesSignalsConfig);
    }

    @DeleteMapping("/{subTypeId}/{signalsConfigId}")
    public void deleteById(@PathVariable UUID subTypeId, @PathVariable UUID signalsConfigId) {
        repository.deleteById(subTypeId, signalsConfigId);
    }
}
