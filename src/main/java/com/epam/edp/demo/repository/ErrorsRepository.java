package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.Errors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ErrorsRepository extends JpaRepository<Errors, UUID> {
}