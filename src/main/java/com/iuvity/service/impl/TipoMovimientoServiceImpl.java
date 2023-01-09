package com.iuvity.service.impl;

import com.iuvity.entity.models.TipoMovimientoEntity;
import com.iuvity.repository.TipoMovimientoEntityRepository;
import com.iuvity.service.TipoMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService {

    @Autowired
    private TipoMovimientoEntityRepository tipoMovimientoRepository;

    @Override
    @Transactional
    public List<TipoMovimientoEntity> findAll() {
        return tipoMovimientoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<TipoMovimientoEntity> findById(int id) {
        return tipoMovimientoRepository.findById(id);
    }

    @Override
    @Transactional
    public TipoMovimientoEntity save(TipoMovimientoEntity tipoMovimientoEntity) {
        return tipoMovimientoRepository.save(tipoMovimientoEntity);
    }

    @Override
    @Transactional
    public boolean existsById(int id) {
        return tipoMovimientoRepository.existsById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(int id){
        try{
            tipoMovimientoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
