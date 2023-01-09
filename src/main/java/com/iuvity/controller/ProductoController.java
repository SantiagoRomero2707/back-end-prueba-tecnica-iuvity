package com.iuvity.controller;

import com.iuvity.dto.Entity.ProductDTO;
import com.iuvity.entity.models.ProductoEntity;
import com.iuvity.dto.utils.Mensaje;
import com.iuvity.service.ProductoService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<ProductoEntity>> getAllProducts(){
        List<ProductoEntity> list = productoService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value= "/detail/{id}")
    public ResponseEntity<ProductoEntity> getProductById(@PathVariable("id") int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("NO existe"), HttpStatus.NOT_FOUND);
        ProductoEntity productoEntity = productoService.findById(id).get();
        return new ResponseEntity<>(productoEntity, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDTO productoDto){
        if(StringUtils.isBlank(productoDto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecioUnitario()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        ProductoEntity productoSave = new ProductoEntity();
        productoSave.setNitProducto(productoDto.getNitProducto());
        productoSave.setNombreProducto(productoDto.getNombreProducto());
        productoSave.setPrecioUnitario(productoDto.getPrecioUnitario());
        productoSave.setProveedor(productoDto.getProveedor());
        productoService.save(productoSave);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductDTO productoDto){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(productoDto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecioUnitario()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        ProductoEntity producto = productoService.findById(id).get();
        producto.setNombreProducto(productoDto.getNombreProducto());
        producto.setNitProducto(productoDto.getNitProducto());
        producto.setProveedor(productoDto.getProveedor());
        producto.setPrecioUnitario(productoDto.getPrecioUnitario());

        productoService.save(producto);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoService.deleteById(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}