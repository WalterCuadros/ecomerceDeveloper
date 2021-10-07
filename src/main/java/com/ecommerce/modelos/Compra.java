/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.modelos;

import java.sql.Date;

/**
 *
 * @author cuadr
 */
public class Compra {
    private int id;
    private float valorObsequio;
    private float valorTotal;
    private Date fechaCompra;
    private int carritoId;

    public Compra(int id, float valorObsequio, float valorTotal, Date fechaCompra, int carritoId) {
        this.id = id;
        this.valorObsequio = valorObsequio;
        this.valorTotal = valorTotal;
        this.fechaCompra = fechaCompra;
        this.carritoId = carritoId;
    }
    public Compra(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorObsequio() {
        return valorObsequio;
    }

    public void setValorObsequio(float valorObsequio) {
        this.valorObsequio = valorObsequio;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(int carritoId) {
        this.carritoId = carritoId;
    }
    
    
}
