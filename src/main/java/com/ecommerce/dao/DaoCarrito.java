/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Carrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DaoCarrito extends Conexion implements IDaoCarrito {

    @Override
    public boolean crearCarrito(Carrito carrito) {
       String sql="INSERT INTO "+FinalBD.T_CARRITO+"("+
                                    FinalBD.TCAR_CLIENTE_ID+","+
                                    FinalBD.TCAR_IS_ACTIVE+") VALUES(?,?)";
        try {
            Connection connection= getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, carrito.getClienteId());
            ps.setBoolean(2, carrito.isActive());
            ps.executeUpdate();
            
            System.out.println("Carrito creado correctamente");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error  al crear el carrito "+e);            
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
    public Carrito getCarrito(String cedula, boolean isActive) {
        int active = isActive?1:0;
        String sql="SELECT * FROM "+FinalBD.T_CARRITO+
                    " JOIN "+FinalBD.T_CLIENTE+
                    " ON "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_CLIENTE_ID+"="+FinalBD.T_CLIENTE+"."+FinalBD.TC_ID+
                    " WHERE "+FinalBD.T_CLIENTE+"."+FinalBD.TC_CEDULA+"='"+cedula+"'"+
                    " AND "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_IS_ACTIVE+"='"+active+"'"+
                    "order by "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_ID+" desc" +
                    " limit 1;";
       
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            Carrito carrito = new Carrito();
            while(resultSet.next()) {  
                               
                carrito.setId(resultSet.getInt(FinalBD.TCAR_ID));
                carrito.setClienteId(resultSet.getInt(FinalBD.TCAR_CLIENTE_ID));
                carrito.setActive(resultSet.getBoolean(FinalBD.TCAR_IS_ACTIVE));
            }           
            return carrito; 
         } catch (SQLException e) {
             
            System.out.println("Error al leer los datos "+e);
            return null;
         }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }  
    
    }

    @Override
    public Boolean actualizarCarrito(Carrito carrito) {
        String sql = "UPDATE "+FinalBD.T_CARRITO+
                " SET "+FinalBD.TCAR_IS_ACTIVE+"= ?"+
                " WHERE "+FinalBD.TCAR_ID+"= ?";
        try {
            Connection connection= getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setBoolean(1, carrito.isActive());
            ps.setInt(2, carrito.getId());
            System.out.println(ps);
            ps.executeUpdate();
            
            System.out.println("Carrito actualizado correctamente");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error  al actualizar el carrito "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
    }
    
}
