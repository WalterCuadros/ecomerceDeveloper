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
public class Carrito {
    private int id;
    private int clienteId;
    private boolean active;

    public Carrito(int id, int clienteId, boolean active) {
        this.id = id;
        this.clienteId = clienteId;
        this.active = active;
    }

    public Carrito(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    

   

}
