/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Cliente;

/**
 *
 * @author cuadr
 */
public interface IDaoCliente {
    public boolean agregarCliente(Cliente cliente);
    public Cliente getCliente(String cedula);
}
