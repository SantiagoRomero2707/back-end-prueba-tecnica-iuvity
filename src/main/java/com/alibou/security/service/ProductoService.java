package com.alibou.security.service;



import com.alibou.security.entity.models.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public List<ProductoEntity> findAll();

    public Optional<ProductoEntity> findById(int id);

    public ProductoEntity save(ProductoEntity productoEntity);

    public boolean existsById (int id);

    public boolean deleteById (int id);


}
