/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Compra;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author cuadr
 */
public interface IDaoCompra {
    public boolean agregarCompra(Compra compra);
    public ArrayList<Compra> getCompras(String cedula);
}
