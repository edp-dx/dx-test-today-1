package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.ErrorMessages1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ErrorMessages1Repository extends JpaRepository<ErrorMessages1, UUID> {
}