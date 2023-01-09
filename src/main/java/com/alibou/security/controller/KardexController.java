package com.alibou.security.controller;


import com.alibou.security.dto.Entity.KardexDTO;
import com.alibou.security.dto.utils.Mensaje;
import com.alibou.security.entity.models.KardexEntity;
import com.alibou.security.service.KardexService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kardex")
public class KardexController {

    private final KardexService kardexService;

    public KardexController(KardexService kardexService) {
        this.kardexService = kardexService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<KardexEntity>> getAllProducts(){
        List<KardexEntity> list = kardexService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<KardexEntity> getProductById(@PathVariable("id") int id){
        if(!kardexService.existsById(id))
            return new ResponseEntity(new Mensaje("NO existe"), HttpStatus.NOT_FOUND);
        KardexEntity kardexEntity = kardexService.findById(id).get();
        return new ResponseEntity<>(kardexEntity, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody KardexDTO kardexDTO){
        if(StringUtils.isBlank(kardexDTO.getDescripciónMovimiento()))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.BAD_REQUEST);

        KardexEntity kardexSaved = new KardexEntity();

        kardexSaved.setCantidadEntrada(kardexDTO.getCantidadEntrada());
        kardexSaved.setCantidadSaldos(kardexDTO.getCantidadSaldos());
        kardexSaved.setCantidadSalida(kardexDTO.getCantidadSalida());
        kardexSaved.setFkIdMovimiento(kardexDTO.getFkIdMovimiento());
        kardexSaved.setFkIdProducto(kardexDTO.getFkIdProducto());
        kardexSaved.setFkIdUser(kardexDTO.getFkIdUser());
        kardexSaved.setValorTotalEntrada(kardexDTO.getValorTotalEntrada());
        kardexSaved.setValorTotalSaldos(kardexDTO.getValorTotalSaldos());
        kardexSaved.setValorTotalSalida(kardexDTO.getValorTotalSalida());
        kardexSaved.setValorUnitarioEntrada(kardexDTO.getValorUnitarioEntrada());
        kardexSaved.setValorUnitarioSaldos(kardexDTO.getValorUnitarioSaldos());
        kardexSaved.setValorUnitarioSalida(kardexDTO.getValorUnitarioSalida());
        kardexSaved.setDescripciónMovimiento(kardexDTO.getDescripciónMovimiento());

        kardexService.save(kardexSaved);
        return new ResponseEntity<>(new Mensaje("Kardex creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody KardexDTO kardexDTO){
        if(StringUtils.isBlank(kardexDTO.getDescripciónMovimiento()))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.BAD_REQUEST);

        KardexEntity kardexSaved = kardexService.findById(id).get();

        kardexSaved.setCantidadEntrada(kardexDTO.getCantidadEntrada());
        kardexSaved.setCantidadSaldos(kardexDTO.getCantidadSaldos());
        kardexSaved.setCantidadSalida(kardexDTO.getCantidadSalida());
        kardexSaved.setFkIdMovimiento(kardexDTO.getFkIdMovimiento());
        kardexSaved.setFkIdProducto(kardexDTO.getFkIdProducto());
        kardexSaved.setFkIdUser(kardexDTO.getFkIdUser());
        kardexSaved.setValorTotalEntrada(kardexDTO.getValorTotalEntrada());
        kardexSaved.setValorTotalSaldos(kardexDTO.getValorTotalSaldos());
        kardexSaved.setValorTotalSalida(kardexDTO.getValorTotalSalida());
        kardexSaved.setValorUnitarioEntrada(kardexDTO.getValorUnitarioEntrada());
        kardexSaved.setValorUnitarioSaldos(kardexDTO.getValorUnitarioSaldos());
        kardexSaved.setValorUnitarioSalida(kardexDTO.getValorUnitarioSalida());
        kardexSaved.setDescripciónMovimiento(kardexDTO.getDescripciónMovimiento());

        kardexService.save(kardexSaved);

        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!kardexService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        kardexService.deleteById(id);
        return new ResponseEntity<>(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
