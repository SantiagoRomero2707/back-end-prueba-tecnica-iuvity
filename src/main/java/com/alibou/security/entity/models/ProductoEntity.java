package com.alibou.security.entity.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "producto", schema = "prueba_tecnica_iuvity", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "nit producto", nullable = true, length = 20)
    private String nitProducto;
    @Basic
    @Column(name = "nombre_producto", nullable = false, length = 50)
    private String nombreProducto;
    @Basic
    @Column(name = "precio_unitario", nullable = false)
    private int precioUnitario;
    @Basic
    @Column(name = "proveedor", nullable = true, length = 30)
    private String proveedor;

    //@OneToMany(mappedBy = "productoByFkIdProducto")
    //private Collection<KardexEntity> kardexesByIdProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNitProducto() {
        return nitProducto;
    }

    public void setNitProducto(String nitProducto) {
        this.nitProducto = nitProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return idProducto == that.idProducto && precioUnitario == that.precioUnitario && Objects.equals(nitProducto, that.nitProducto) && Objects.equals(nombreProducto, that.nombreProducto) && Objects.equals(proveedor, that.proveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nitProducto, nombreProducto, precioUnitario, proveedor);
    }


    /*public Collection<KardexEntity> getKardexesByIdProducto() {
        return kardexesByIdProducto;
    }

    public void setKardexesByIdProducto(Collection<KardexEntity> kardexesByIdProducto) {
        this.kardexesByIdProducto = kardexesByIdProducto;
    }*/
}
