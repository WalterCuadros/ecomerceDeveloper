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
public class ProductoCarritoVista extends ProductoVista {
    
    private int cantidadProducto;

    public ProductoCarritoVista(int cantidadProducto, String tipoProductoNombre, int id, String codigoBarras, String nombre, String marca, Date fechaVencimiento, float precio, float descuento, int tipoProducto) {
        super(tipoProductoNombre, id, codigoBarras, nombre, marca, fechaVencimiento, precio, descuento, tipoProducto);
        this.cantidadProducto = cantidadProducto;
    }

    public ProductoCarritoVista(int cantidadProducto, String tipoProductoNombre) {
        super(tipoProductoNombre);
        this.cantidadProducto = cantidadProducto;
    }

    public ProductoCarritoVista(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
   

   
    public ProductoCarritoVista(){}

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    
}
