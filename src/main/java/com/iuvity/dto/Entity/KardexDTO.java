package com.iuvity.dto.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class KardexDTO {
    @Min(0)
    @NotBlank
    private int cantidadEntrada;
    @Min(0)
    @NotBlank
    private int cantidadSaldos;
    @Min(0)
    @NotBlank
    private int cantidadSalida;
    @NotBlank
    private String descripciónMovimiento;
    @NotBlank
    @Min(0)
    private int fkIdMovimiento;
    @NotBlank
    @Min(0)
    private int fkIdProducto;
    @NotBlank
    private String fkIdUser;
    @NotBlank
    @Min(0)
    private int valorTotalEntrada;
    @NotBlank
    @Min(0)
    private int valorTotalSaldos;
    @NotBlank
    @Min(0)
    private int valorTotalSalida;
    @NotBlank
    @Min(0)
    private int valorUnitarioEntrada;
    @NotBlank
    @Min(0)
    private int valorUnitarioSaldos;
    @NotBlank
    @Min(0)
    private int valorUnitarioSalida;

    public int getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(int cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public int getCantidadSaldos() {
        return cantidadSaldos;
    }

    public void setCantidadSaldos(int cantidadSaldos) {
        this.cantidadSaldos = cantidadSaldos;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public String getDescripciónMovimiento() {
        return descripciónMovimiento;
    }

    public void setDescripciónMovimiento(String descripciónMovimiento) {
        this.descripciónMovimiento = descripciónMovimiento;
    }

    public int getFkIdMovimiento() {
        return fkIdMovimiento;
    }

    public void setFkIdMovimiento(int fkIdMovimiento) {
        this.fkIdMovimiento = fkIdMovimiento;
    }

    public int getFkIdProducto() {
        return fkIdProducto;
    }

    public void setFkIdProducto(int fkIdProducto) {
        this.fkIdProducto = fkIdProducto;
    }

    public String getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(String fkIdUser) {
        this.fkIdUser = fkIdUser;
    }

    public int getValorTotalEntrada() {
        return valorTotalEntrada;
    }

    public void setValorTotalEntrada(int valorTotalEntrada) {
        this.valorTotalEntrada = valorTotalEntrada;
    }

    public int getValorTotalSaldos() {
        return valorTotalSaldos;
    }

    public void setValorTotalSaldos(int valorTotalSaldos) {
        this.valorTotalSaldos = valorTotalSaldos;
    }

    public int getValorTotalSalida() {
        return valorTotalSalida;
    }

    public void setValorTotalSalida(int valorTotalSalida) {
        this.valorTotalSalida = valorTotalSalida;
    }

    public int getValorUnitarioEntrada() {
        return valorUnitarioEntrada;
    }

    public void setValorUnitarioEntrada(int valorUnitarioEntrada) {
        this.valorUnitarioEntrada = valorUnitarioEntrada;
    }

    public int getValorUnitarioSaldos() {
        return valorUnitarioSaldos;
    }

    public void setValorUnitarioSaldos(int valorUnitarioSaldos) {
        this.valorUnitarioSaldos = valorUnitarioSaldos;
    }

    public int getValorUnitarioSalida() {
        return valorUnitarioSalida;
    }

    public void setValorUnitarioSalida(int valorUnitarioSalida) {
        this.valorUnitarioSalida = valorUnitarioSalida;
    }

    public KardexDTO(int cantidadEntrada, int cantidadSaldos, int cantidadSalida, String descripciónMovimiento, int fkIdMovimiento, int fkIdProducto, String fkIdUser, int valorTotalEntrada, int valorTotalSaldos, int valorTotalSalida, int valorUnitarioEntrada, int valorUnitarioSaldos, int valorUnitarioSalida) {
        this.cantidadEntrada = cantidadEntrada;
        this.cantidadSaldos = cantidadSaldos;
        this.cantidadSalida = cantidadSalida;
        this.descripciónMovimiento = descripciónMovimiento;
        this.fkIdMovimiento = fkIdMovimiento;
        this.fkIdProducto = fkIdProducto;
        this.fkIdUser = fkIdUser;
        this.valorTotalEntrada = valorTotalEntrada;
        this.valorTotalSaldos = valorTotalSaldos;
        this.valorTotalSalida = valorTotalSalida;
        this.valorUnitarioEntrada = valorUnitarioEntrada;
        this.valorUnitarioSaldos = valorUnitarioSaldos;
        this.valorUnitarioSalida = valorUnitarioSalida;
    }
}
