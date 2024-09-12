package com.epam.edp.demo.controller;

import com.epam.edp.demo.entity.SupplierUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.edp.demo.repository.SupplierUsersRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supplier-users")
public class SupplierUsersController {

    @Autowired
    private SupplierUsersRepository repository;

    @GetMapping
    public List<SupplierUsers> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierUsers> findById(@PathVariable UUID id) {
        Optional<SupplierUsers> supplierUser = repository.findById(id);
        return supplierUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SupplierUsers save(@RequestBody SupplierUsers supplierUser) {
        return repository.save(supplierUser);
    }

    @PutMapping
    public SupplierUsers update(@RequestBody SupplierUsers supplierUser) {
        return repository.save(supplierUser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
