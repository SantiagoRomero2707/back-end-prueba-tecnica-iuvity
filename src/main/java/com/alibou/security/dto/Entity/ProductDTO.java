package com.alibou.security.dto.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

    @NotBlank
    private String nombreProducto;
    @NotBlank
    @Min(0)
    private int precioUnitario;
    @NotBlank
    private String nitProducto;
    @NotBlank
    private String proveedor;

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

    public String getNitProducto() {
        return nitProducto;
    }

    public void setNitProducto(String nitProducto) {
        this.nitProducto = nitProducto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public ProductDTO(String nombreProducto, int precioUnitario, String nitProducto, String proveedor) {
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.nitProducto = nitProducto;
        this.proveedor = proveedor;
    }
}
