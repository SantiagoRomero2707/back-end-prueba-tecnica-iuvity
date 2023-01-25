package com.iuvity.repository;

import com.iuvity.entity.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoEntityRepository extends JpaRepository<ProductoEntity, Integer> {
}