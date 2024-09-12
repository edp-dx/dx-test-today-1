package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.ProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ProductStatusRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-status")
public class ProductStatusController {

    @Autowired
    private ProductStatusRepository repository;

    @GetMapping
    public List<ProductStatus> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductStatus> findById(@PathVariable UUID id) {
        Optional<ProductStatus> productStatus = repository.findById(id);
        return productStatus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductStatus save(@RequestBody ProductStatus productStatus) {
        return repository.save(productStatus);
    }

    @PutMapping
    public ProductStatus update(@RequestBody ProductStatus productStatus) {
        return repository.save(productStatus);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
