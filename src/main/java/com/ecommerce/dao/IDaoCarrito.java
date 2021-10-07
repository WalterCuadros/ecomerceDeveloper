
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Carrito;
import com.ecommerce.modelos.ProductoCarrito;
import java.util.ArrayList;

/**
 *
 * @author cuadr
 */
public interface IDaoCarrito {
    
    public boolean crearCarrito(Carrito carrito);
    public Carrito getCarrito(String cedula, boolean isActive);
    public Boolean actualizarCarrito(Carrito carrito);
}
