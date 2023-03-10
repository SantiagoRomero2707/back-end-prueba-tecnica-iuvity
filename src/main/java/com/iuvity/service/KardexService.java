package com.iuvity.service;



import com.iuvity.entity.models.KardexEntity;

import java.util.List;
import java.util.Optional;

public interface KardexService {

    public List<KardexEntity> findAll();

    public Optional<KardexEntity> findById(int id);

    public KardexEntity save(KardexEntity kardexEntity);

    public boolean existsById (int id);

    public boolean deleteById (int id);


}
