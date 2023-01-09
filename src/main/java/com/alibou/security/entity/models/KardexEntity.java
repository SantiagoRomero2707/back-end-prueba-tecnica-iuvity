package com.alibou.security.entity.models;

import com.alibou.security.security.entity.User;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "kardex", schema = "prueba_tecnica_iuvity")
public class KardexEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_kardex", nullable = false)
    private int idKardex;
    @Basic
    @Column(name = "cantidad_entrada", nullable = false)
    private int cantidadEntrada;
    @Basic
    @Column(name = "cantidad_saldos", nullable = false)
    private int cantidadSaldos;
    @Basic
    @Column(name = "cantidad_salida", nullable = false)
    private int cantidadSalida;
    @Basic
    @Column(name = "descripción_movimiento", nullable = false, length = 50)
    private String descripciónMovimiento;
    @Basic
    @Column(name = "fk_id_movimiento", nullable = false)
    private int fkIdMovimiento;
    @Basic
    @Column(name = "fk_id_producto", nullable = false)
    private int fkIdProducto;
    @Basic
    @Column(name = "fk_id_user", nullable = false, length = 255)
    private String fkIdUser;
    @Basic
    @Column(name = "valor_total_entrada", nullable = false)
    private int valorTotalEntrada;
    @Basic
    @Column(name = "valor_total_saldos", nullable = false)
    private int valorTotalSaldos;
    @Basic
    @Column(name = "valor_total_salida", nullable = false)
    private int valorTotalSalida;
    @Basic
    @Column(name = "valor_unitario_entrada", nullable = false)
    private int valorUnitarioEntrada;
    @Basic
    @Column(name = "valor_unitario_saldos", nullable = false)
    private int valorUnitarioSaldos;
    @Basic
    @Column(name = "valor_unitario_salida", nullable = false)
    private int valorUnitarioSalida;

    @ManyToOne
    @JoinColumn(name = "fk_id_movimiento", referencedColumnName = "id_movimiento", nullable = false, insertable = false, updatable = false)
    private TipoMovimientoEntity tipoMovimientoByFkIdMovimiento;
    @ManyToOne
    @JoinColumn(name = "fk_id_producto", referencedColumnName = "id_producto", nullable = false, insertable = false, updatable = false)
    private ProductoEntity productoByFkIdProducto;
    @ManyToOne
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_primary", nullable = false, insertable = false, updatable = false)
    private User usersByFkIdUser;


    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KardexEntity that = (KardexEntity) o;
        return idKardex == that.idKardex && cantidadEntrada == that.cantidadEntrada && cantidadSaldos == that.cantidadSaldos && cantidadSalida == that.cantidadSalida && fkIdMovimiento == that.fkIdMovimiento && fkIdProducto == that.fkIdProducto && valorTotalEntrada == that.valorTotalEntrada && valorTotalSaldos == that.valorTotalSaldos && valorTotalSalida == that.valorTotalSalida && valorUnitarioEntrada == that.valorUnitarioEntrada && valorUnitarioSaldos == that.valorUnitarioSaldos && valorUnitarioSalida == that.valorUnitarioSalida && Objects.equals(descripciónMovimiento, that.descripciónMovimiento) && Objects.equals(fkIdUser, that.fkIdUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKardex, cantidadEntrada, cantidadSaldos, cantidadSalida, descripciónMovimiento, fkIdMovimiento, fkIdProducto, fkIdUser, valorTotalEntrada, valorTotalSaldos, valorTotalSalida, valorUnitarioEntrada, valorUnitarioSaldos, valorUnitarioSalida);
    }

    public TipoMovimientoEntity getTipoMovimientoByFkIdMovimiento() {
        return tipoMovimientoByFkIdMovimiento;
    }

    public void setTipoMovimientoByFkIdMovimiento(TipoMovimientoEntity tipoMovimientoByFkIdMovimiento) {
        this.tipoMovimientoByFkIdMovimiento = tipoMovimientoByFkIdMovimiento;
    }

    public ProductoEntity getProductoByFkIdProducto() {
        return productoByFkIdProducto;
    }

    public void setProductoByFkIdProducto(ProductoEntity productoByFkIdProducto) {
        this.productoByFkIdProducto = productoByFkIdProducto;
    }

    public User getUsersByFkIdUser() {
        return usersByFkIdUser;
    }

    public void setUsersByFkIdUser(User usersByFkIdUser) {
        this.usersByFkIdUser = usersByFkIdUser;
    }
}
