/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Producto;
import com.ecommerce.modelos.ProductoVista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cuadr
 */
public class DaoProducto extends Conexion implements IDaoProducto{

    @Override
    public ArrayList<ProductoVista> traerProductos(int tipoProducto, boolean productosDescuento) {
        ArrayList<ProductoVista> arrayListProductoVista =new ArrayList<>();
        String sentence ="";
        if(productosDescuento){
            sentence = " AND "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_DESCUENTO+" > 0 ";
        }
        String sql="SELECT "+FinalBD.T_PRODUCTO+".*, "+FinalBD.T_TIPO_PRODUCTO+"."+FinalBD.TTP_NOMBRE+" AS "+ FinalBD.TP_TIPO_PRODUCTO_NOMBRE +
                   " FROM "+FinalBD.T_PRODUCTO+
                   " JOIN "+FinalBD.T_TIPO_PRODUCTO+
                   " ON "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_TIPO_PRODUCTO+"="+FinalBD.T_TIPO_PRODUCTO+"."+FinalBD.TTP_ID+
                   " WHERE "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_TIPO_PRODUCTO+"='"+tipoProducto+"'"+sentence+
                   " ORDER BY "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_ID+" DESC";
        try {
           Connection connection=getConexion();
           PreparedStatement ps=connection.prepareStatement(sql);
           ResultSet resultSet=ps.executeQuery();
           
            while (resultSet.next()) {  
                
                ProductoVista productoVista = new ProductoVista();
                productoVista.setId(resultSet.getInt(FinalBD.TP_ID));
                productoVista.setNombre(resultSet.getString(FinalBD.TP_NOMBRE));
                productoVista.setCodigoBarras(resultSet.getString(FinalBD.TP_CODIGO_BARRAS));
                productoVista.setTipoProducto(resultSet.getInt(FinalBD.TP_TIPO_PRODUCTO));
                productoVista.setMarca(resultSet.getString(FinalBD.TP_MARCA));
                productoVista.setFechaVencimiento(resultSet.getDate(FinalBD.TP_FECHA_VENCIMIENTO));
                productoVista.setPrecio(resultSet.getBigDecimal(FinalBD.TP_PRECIO).floatValue());
                productoVista.setDescuento(resultSet.getBigDecimal(FinalBD.TP_DESCUENTO).floatValue());
                productoVista.setTipoProductoNombre(resultSet.getString(FinalBD.TP_TIPO_PRODUCTO_NOMBRE));
            
                
                arrayListProductoVista.add(productoVista);
            }
        } catch (SQLException e) {

           System.out.println("Error al leer los datos "+e);
           return arrayListProductoVista;
        }finally{
            try {
               getConexion().close();
           } catch(SQLException e) {
               System.err.println("Error al cerrar la conexion "+e);
           }
       }  
        return arrayListProductoVista;

    }

    @Override
    public Producto getProducto(String codigoBarras) {
        Producto producto=new Producto();
        String sql="SELECT "+FinalBD.T_PRODUCTO+".*, "+FinalBD.T_TIPO_PRODUCTO+".*"+
                    " FROM "+FinalBD.T_PRODUCTO+
                    " JOIN "+FinalBD.T_TIPO_PRODUCTO+
                    " ON "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_TIPO_PRODUCTO+"="+FinalBD.T_TIPO_PRODUCTO+"."+FinalBD.TTP_ID+
                    " WHERE "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_CODIGO_BARRAS+"='"+codigoBarras+"'"+
                    " ORDER BY "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_ID+" DESC";
         try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
             while (resultSet.next()) {  
                producto.setId(resultSet.getInt(FinalBD.TP_ID));
                producto.setCodigoBarras(resultSet.getString(FinalBD.TP_CODIGO_BARRAS));
                producto.setNombre(resultSet.getString(FinalBD.TP_NOMBRE));
                producto.setMarca(resultSet.getString(FinalBD.TP_MARCA));
                producto.setFechaVencimiento(resultSet.getDate(FinalBD.TP_FECHA_VENCIMIENTO));
                producto.setPrecio(resultSet.getBigDecimal(FinalBD.TP_PRECIO).floatValue());
                producto.setDescuento(resultSet.getBigDecimal(FinalBD.TP_DESCUENTO).floatValue());
                
            }
             
         } catch (SQLException e) {
             
            System.out.println("Error al leer los datos "+e);
            return producto;
         }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }  
        return producto;
    }

    
}
