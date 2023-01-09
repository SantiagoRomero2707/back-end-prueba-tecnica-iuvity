package com.alibou.security.entity.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_movimiento", schema = "prueba_tecnica_iuvity", catalog = "")
public class TipoMovimientoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_movimiento", nullable = false)
    private int idMovimiento;
    @Basic
    @Column(name = "fecha_movimiento", nullable = true)
    private Timestamp fechaMovimiento;
    @Basic
    @Column(name = "tipo_movimiento", nullable = true, length = 20)
    private String tipoMovimiento;

    //@OneToMany(mappedBy = "tipoMovimientoByFkIdMovimiento")

    //private Collection<KardexEntity> kardexesByIdMovimiento;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoMovimientoEntity that = (TipoMovimientoEntity) o;
        return idMovimiento == that.idMovimiento && Objects.equals(fechaMovimiento, that.fechaMovimiento) && Objects.equals(tipoMovimiento, that.tipoMovimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovimiento, fechaMovimiento, tipoMovimiento);
    }

    /*public Collection<KardexEntity> getKardexesByIdMovimiento() {
        return kardexesByIdMovimiento;
    }

    public void setKardexesByIdMovimiento(Collection<KardexEntity> kardexesByIdMovimiento) {
        this.kardexesByIdMovimiento = kardexesByIdMovimiento;
    }*/
}
