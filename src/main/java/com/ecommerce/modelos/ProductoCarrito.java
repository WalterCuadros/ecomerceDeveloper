/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.modelos;

/**
 *
 * @author cuadr
 */
public class ProductoCarrito {
    private int id;
    private int cantidadProducto;
    private int productoId;
    private boolean inCarrito;
    private int carritoId;

    public ProductoCarrito(int id, int cantidadProducto, int productoId, boolean inCarrito, int carritoId) {
        this.id = id;
        this.cantidadProducto = cantidadProducto;
        this.productoId = productoId;
        this.inCarrito = inCarrito;
        this.carritoId = carritoId;
    }

    public ProductoCarrito(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public boolean isInCarrito() {
        return inCarrito;
    }

    public void setInCarrito(boolean inCarrito) {
        this.inCarrito = inCarrito;
    }

    public int getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(int carritoId) {
        this.carritoId = carritoId;
    }
    
    

}
