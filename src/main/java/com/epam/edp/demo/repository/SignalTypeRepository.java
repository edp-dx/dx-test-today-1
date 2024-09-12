package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.SignalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SignalTypeRepository extends JpaRepository<SignalType, UUID> {
}