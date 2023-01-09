package com.alibou.security.repository;


import com.alibou.security.entity.models.TipoMovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMovimientoEntityRepository extends JpaRepository<TipoMovimientoEntity, Integer> {
}