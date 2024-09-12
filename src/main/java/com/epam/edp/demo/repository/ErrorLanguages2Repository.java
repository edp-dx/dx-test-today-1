package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.ErrorLanguages2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ErrorLanguages2Repository extends JpaRepository<ErrorLanguages2, UUID> {
}