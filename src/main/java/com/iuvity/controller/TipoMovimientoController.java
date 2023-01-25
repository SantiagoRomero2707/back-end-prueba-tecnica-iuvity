package com.iuvity.controller;

import com.iuvity.dto.Entity.TipoMovimientoDTO;
import com.iuvity.entity.models.TipoMovimientoEntity;
import com.iuvity.dto.utils.Mensaje;
import com.iuvity.service.TipoMovimientoService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movimiento")
public class TipoMovimientoController {

    private final TipoMovimientoService tipoMovimientoService;

    public TipoMovimientoController(TipoMovimientoService tipoMovimientoService) {
        this.tipoMovimientoService = tipoMovimientoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<TipoMovimientoEntity>> getAllMovements(){
        List<TipoMovimientoEntity> list = tipoMovimientoService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TipoMovimientoEntity> getProductById(@PathVariable("id") int id){
        if(!tipoMovimientoService.existsById(id))
            return new ResponseEntity(new Mensaje("NO existe"), HttpStatus.NOT_FOUND);
        TipoMovimientoEntity tipoMovimientoEntity = tipoMovimientoService.findById(id).get();
        return new ResponseEntity<>(tipoMovimientoEntity, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipoMovimientoDTO tipoMovimientoDTO){
        if(StringUtils.isBlank(String.valueOf(tipoMovimientoDTO.getFechaMovimiento())))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tipoMovimientoDTO.getTipoMovimiento()))
            return new ResponseEntity(new Mensaje("El tipo de movimiento es obligatario"), HttpStatus.BAD_REQUEST);
        TipoMovimientoEntity movementSave = new TipoMovimientoEntity();
        movementSave.setTipoMovimiento(tipoMovimientoDTO.getTipoMovimiento());
        movementSave.setFechaMovimiento(tipoMovimientoDTO.getFechaMovimiento());
        tipoMovimientoService.save(movementSave);
        return new ResponseEntity(new Mensaje("Movimiento registrado y creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody  TipoMovimientoDTO tipoMovimientoDTO){
        if(!tipoMovimientoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(String.valueOf(tipoMovimientoDTO.getFechaMovimiento())))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tipoMovimientoDTO.getTipoMovimiento()))
            return new ResponseEntity(new Mensaje("El tipo de movimiento es obligatario"), HttpStatus.BAD_REQUEST);

        TipoMovimientoEntity tipoMovimientoEntity = tipoMovimientoService.findById(id).get();
        tipoMovimientoEntity.setTipoMovimiento(tipoMovimientoDTO.getTipoMovimiento());
        tipoMovimientoEntity.setFechaMovimiento(tipoMovimientoDTO.getFechaMovimiento());
        tipoMovimientoService.save(tipoMovimientoEntity);
        return new ResponseEntity(new Mensaje("Movimiento actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!tipoMovimientoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        tipoMovimientoService.deleteById(id);
        return new ResponseEntity(new Mensaje("Movimiento eliminado"), HttpStatus.OK);
    }
}