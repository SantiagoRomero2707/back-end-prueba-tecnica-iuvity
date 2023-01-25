package com.iuvity.dto.Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public class TipoMovimientoDTO {
    @NotBlank
    private Timestamp fechaMovimiento;
    @NotBlank
    private String tipoMovimiento;

    public Timestamp getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Timestamp fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public TipoMovimientoDTO(Timestamp fechaMovimiento, String tipoMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
        this.tipoMovimiento = tipoMovimiento;
    }
}
