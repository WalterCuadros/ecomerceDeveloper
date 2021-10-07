/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Producto;
import com.ecommerce.modelos.ProductoCarrito;
import com.ecommerce.modelos.ProductoCarritoVista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cuadr
 */
public class DaoProductoCarrito extends Conexion implements IDaoProductoCarrito{

    @Override
    public boolean crearProductoCarrito(ProductoCarrito productoCarrito) {
        String sql="INSERT INTO "+FinalBD.T_PRODUCTO_CARRITO+"("+
                                    FinalBD.TPC_CANTIDAD_PRODUCTO+","+
                                    FinalBD.TPC_PRODUCTO_ID+","+
                                    FinalBD.TPC_IN_CARRITO+","+
                                    FinalBD.TPC_CARRITO_ID+") VALUES(?,?,?,?)";
        try {
            Connection connection= getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, productoCarrito.getCantidadProducto());
            ps.setInt(2, productoCarrito.getProductoId());
            ps.setBoolean(3, productoCarrito.isInCarrito());
            ps.setInt(4, productoCarrito.getCarritoId());
            ps.executeUpdate();
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error  al crear el producto en el carrito "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
    }

    @Override
    public boolean actualizarProductoCarrito(ProductoCarrito productoCarrito) {
        String sql = "UPDATE "+FinalBD.T_PRODUCTO_CARRITO+
                " SET "+FinalBD.TPC_CANTIDAD_PRODUCTO+" = ?,"+
                FinalBD.TPC_IN_CARRITO+" = ?"+ 
                " WHERE "+FinalBD.TPC_ID+" = ?";
        
        try {
            Connection connection= getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, productoCarrito.getCantidadProducto());
            ps.setBoolean(2, productoCarrito.isInCarrito());
            ps.setInt(3, productoCarrito.getId());
            System.out.println(ps);
            ps.executeUpdate();
            
            System.out.println("Producto actualizado correctamente en el carrito");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error  al actualizar el producto en el carrito "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
    }

    @Override
    public ArrayList<ProductoCarritoVista> visualizarProductoCarrito(String cedula, int idTipoProducto, boolean inCarrito, boolean withTipoProducto) {
        String sentence =(withTipoProducto)?" AND "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_TIPO_PRODUCTO+"='"+idTipoProducto+"'":"";
        
        ArrayList<ProductoCarritoVista> arrayListProductoCarritoVista =new ArrayList<>();
        String sql="SELECT "+FinalBD.T_PRODUCTO_CARRITO+".*, "+FinalBD.T_TIPO_PRODUCTO+"."+FinalBD.TTP_NOMBRE+" AS "+ FinalBD.TP_TIPO_PRODUCTO_NOMBRE+" , "+FinalBD.T_PRODUCTO+".*"+
                   " FROM "+FinalBD.T_PRODUCTO_CARRITO+
                   " JOIN "+FinalBD.T_PRODUCTO+
                   " ON "+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_PRODUCTO_ID+"="+FinalBD.T_PRODUCTO+"."+FinalBD.TP_ID+
                   " JOIN "+FinalBD.T_TIPO_PRODUCTO+
                   " ON "+FinalBD.T_PRODUCTO+"."+FinalBD.TP_TIPO_PRODUCTO+"="+FinalBD.T_TIPO_PRODUCTO+"."+FinalBD.TTP_ID+
                   " JOIN "+FinalBD.T_CARRITO+
                   " ON "+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_CARRITO_ID+"="+FinalBD.T_CARRITO+"."+FinalBD.TCAR_ID+
                   " JOIN "+FinalBD.T_CLIENTE+
                   " ON "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_CLIENTE_ID+"="+FinalBD.T_CLIENTE+"."+FinalBD.TC_ID+
                   " WHERE "+FinalBD.T_CLIENTE+"."+FinalBD.TC_CEDULA+"='"+cedula+"'"+
                   " AND "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_IS_ACTIVE+"='1'"+
                   sentence+
                   " AND "+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_IN_CARRITO+"='1'"+
                   " ORDER BY "+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_ID+" DESC";
                   
         try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()) {  

                ProductoCarritoVista productoCarritoVista = new ProductoCarritoVista();
                productoCarritoVista.setId(resultSet.getInt(FinalBD.TPC_ID));
                productoCarritoVista.setNombre(resultSet.getString(FinalBD.TP_NOMBRE));
                productoCarritoVista.setCodigoBarras(resultSet.getString(FinalBD.TP_CODIGO_BARRAS));
                productoCarritoVista.setTipoProducto(resultSet.getInt(FinalBD.TP_TIPO_PRODUCTO));
                productoCarritoVista.setMarca(resultSet.getString(FinalBD.TP_MARCA));
                productoCarritoVista.setFechaVencimiento(resultSet.getDate(FinalBD.TP_FECHA_VENCIMIENTO));
                productoCarritoVista.setPrecio(resultSet.getFloat(FinalBD.TP_PRECIO));
                productoCarritoVista.setDescuento(resultSet.getFloat(FinalBD.TP_DESCUENTO));
                productoCarritoVista.setTipoProductoNombre(resultSet.getString(FinalBD.TP_TIPO_PRODUCTO_NOMBRE));
                productoCarritoVista.setCantidadProducto(resultSet.getInt(FinalBD.TPC_CANTIDAD_PRODUCTO));
              


              arrayListProductoCarritoVista.add(productoCarritoVista);
          }
         } catch (SQLException e) {
             
            System.out.println("Error al leer los datos "+e);
            return arrayListProductoCarritoVista;
         }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }  
        return arrayListProductoCarritoVista;
    }
    
    
    
    @Override
    public ProductoCarrito getProductoCarrito(int identificador){
        ProductoCarrito productoCarrito = new ProductoCarrito();
        String sql="SELECT "+FinalBD.T_PRODUCTO_CARRITO+".* "+
                    " FROM "+FinalBD.T_PRODUCTO_CARRITO+
                    " WHERE "+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_ID+"='"+identificador+"'";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
             while (resultSet.next()) {  
                productoCarrito.setId(resultSet.getInt(FinalBD.TPC_ID));
                productoCarrito.setInCarrito(resultSet.getBoolean(FinalBD.TPC_IN_CARRITO));
              
            }
             
        } catch (SQLException e) {
             
            System.out.println("Error al leer los datos "+e);
            return productoCarrito;
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }  
            return productoCarrito;
    }

    
    @Override
    public int getCantidadProductos(String cedula, boolean inCarrito) {
           String inCarrritoString = (inCarrito)?"1":"0";
            int cantidadProductosSacados = 0;
            String sql="SELECT  count("+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_ID+" ) AS cnt"+
                " FROM "+FinalBD.T_PRODUCTO_CARRITO+
                " JOIN "+FinalBD.T_CARRITO+
                " ON "+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_CARRITO_ID+"="+FinalBD.T_CARRITO+"."+FinalBD.TCAR_ID+
                " JOIN "+FinalBD.T_CLIENTE+
                " ON "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_CLIENTE_ID+"="+FinalBD.T_CLIENTE+"."+FinalBD.TC_ID+
                " WHERE "+FinalBD.T_CLIENTE+"."+FinalBD.TC_CEDULA+"='"+cedula+"'"+
                " AND "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_IS_ACTIVE+"= 1"+
                " AND "+FinalBD.T_PRODUCTO_CARRITO+"."+FinalBD.TPC_IN_CARRITO+"= "+inCarrritoString;
             
            try {
                Connection connection=getConexion();
                PreparedStatement ps=connection.prepareStatement(sql);
                ResultSet resultSet=ps.executeQuery();

                while (resultSet.next()) {  

                    cantidadProductosSacados = resultSet.getInt("cnt");
              
                }
            } catch (SQLException e) {

               System.out.println("Error al leer los datos "+e);
               return cantidadProductosSacados;
            }finally{
                try {
                   getConexion().close();
               } catch(SQLException e) {
                   System.err.println("Error al cerrar la conexion "+e);
               }
           }  
           return cantidadProductosSacados;
     }
    
}
