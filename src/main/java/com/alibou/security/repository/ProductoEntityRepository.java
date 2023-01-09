package com.alibou.security.repository;

import com.alibou.security.entity.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoEntityRepository extends JpaRepository<ProductoEntity, Integer> {
}