package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.ProjectMainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProjectMainTypeRepository extends JpaRepository<ProjectMainType, UUID> {
}