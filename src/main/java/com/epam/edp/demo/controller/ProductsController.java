package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.ProductsRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsRepository repository;

    @GetMapping
    public List<Products> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable UUID id) {
        Optional<Products> product = repository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Products save(@RequestBody Products product) {
        return repository.save(product);
    }

    @PutMapping
    public Products update(@RequestBody Products product) {
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
