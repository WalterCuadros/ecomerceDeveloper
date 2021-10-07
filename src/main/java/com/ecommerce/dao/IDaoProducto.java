/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Producto;
import com.ecommerce.modelos.ProductoVista;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author cuadr
 */
public interface IDaoProducto {
    
    public ArrayList<ProductoVista>  traerProductos(int tipoProducto, boolean productosDescuento);
    public Producto getProducto(String codigoBarras);
    
}
