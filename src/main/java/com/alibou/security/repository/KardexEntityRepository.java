package com.alibou.security.repository;

import com.alibou.security.entity.models.KardexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KardexEntityRepository extends JpaRepository<KardexEntity, Integer> {
}