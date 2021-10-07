/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.ProductoCarrito;
import com.ecommerce.modelos.ProductoCarritoVista;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author cuadr
 */
public interface IDaoProductoCarrito {
    public boolean crearProductoCarrito(ProductoCarrito productoCarrito);
    public boolean actualizarProductoCarrito(ProductoCarrito productoCarrito);
    public ArrayList<ProductoCarritoVista> visualizarProductoCarrito(String cedula, int idTipoProducto, boolean inCarrito, boolean withTipoProducto);
    public ProductoCarrito getProductoCarrito(int identificador);
    public int getCantidadProductos(String cedula,boolean inCarrito);
}
