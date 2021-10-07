package com.ecommerce.modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author cuadr
 */
public class Cliente {
    private int id;
    private String nombre;
    private String cedula; 
    private String tarjeta;
    private String email;

    public Cliente( String nombre, String cedula, String tarjeta, String email) {
       
        this.nombre = nombre;
        this.cedula = cedula;
        this.tarjeta = tarjeta;
        this.email = email;
    }
    public Cliente(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
