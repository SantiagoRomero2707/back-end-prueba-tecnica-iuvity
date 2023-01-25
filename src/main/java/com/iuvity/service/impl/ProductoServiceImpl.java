package com.iuvity.service.impl;


import com.iuvity.entity.models.ProductoEntity;
import com.iuvity.repository.ProductoEntityRepository;
import com.iuvity.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoEntityRepository productoRepository;

    public ProductoServiceImpl(ProductoEntityRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<ProductoEntity> findById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public ProductoEntity save(ProductoEntity productoEntity) {
        return productoRepository.save(productoEntity);
    }

    @Override
    @Transactional
    public boolean existsById(int id) {
        return productoRepository.existsById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(int id){
        try{
            productoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
