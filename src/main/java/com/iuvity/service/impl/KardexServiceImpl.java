package com.iuvity.service.impl;

import com.iuvity.entity.models.KardexEntity;
import com.iuvity.repository.KardexEntityRepository;
import com.iuvity.service.KardexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KardexServiceImpl implements KardexService {

    private final KardexEntityRepository kardexRepository;

    public KardexServiceImpl(KardexEntityRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }

    @Override
    @Transactional
    public List<KardexEntity> findAll() {
        return kardexRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<KardexEntity> findById(int id) {
        return kardexRepository.findById(id);
    }

    @Override
    @Transactional
    public KardexEntity save(KardexEntity kardexEntity) {
        return kardexRepository.save(kardexEntity);
    }

    @Override
    @Transactional
    public boolean existsById(int id) {
        return kardexRepository.existsById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(int id){
        try{
            kardexRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
