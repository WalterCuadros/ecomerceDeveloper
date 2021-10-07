/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.modelos;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class ProductoVista extends Producto{
    private String tipoProductoNombre;

    public ProductoVista(String tipoProductoNombre, int id, String codigoBarras, String nombre, String marca, Date fechaVencimiento, float precio, float descuento, int tipoProducto) {
        super(id, codigoBarras, nombre, marca, fechaVencimiento, precio, descuento, tipoProducto);
        this.tipoProductoNombre = tipoProductoNombre;
    }

    public ProductoVista(String tipoProductoNombre) {
        this.tipoProductoNombre = tipoProductoNombre;
    }
   
    public ProductoVista(){}
    
    public String getTipoProductoNombre() {
        return tipoProductoNombre;
    }

    public void setTipoProductoNombre(String tipoProductoNombre) {
        this.tipoProductoNombre = tipoProductoNombre;
    }
    
    
}
