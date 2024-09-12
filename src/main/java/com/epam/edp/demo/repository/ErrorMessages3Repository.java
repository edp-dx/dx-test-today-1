package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.ErrorMessages3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ErrorMessages3Repository extends JpaRepository<ErrorMessages3, UUID> {
}