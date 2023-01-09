package com.iuvity.service;


import com.iuvity.entity.models.TipoMovimientoEntity;

import java.util.List;
import java.util.Optional;

public interface TipoMovimientoService {

    public List<TipoMovimientoEntity> findAll();

    public Optional<TipoMovimientoEntity> findById(int id);

    public TipoMovimientoEntity save(TipoMovimientoEntity tipoMovimientoEntity);

    public boolean existsById (int id);

    public boolean deleteById (int id);


}
