package com.epam.edp.demo.repository;

import com.epam.edp.demo.entity.ProjectsProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProjectsProductsRepository extends JpaRepository<ProjectsProducts, UUID> {
}