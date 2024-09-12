package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.MainTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MainTypesRepository extends JpaRepository<MainTypes, UUID> {
}