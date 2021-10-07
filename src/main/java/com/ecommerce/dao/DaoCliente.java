/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DaoCliente extends Conexion implements IDaoCliente  {

    @Override
    public boolean agregarCliente(Cliente cliente) {
        String sql="INSERT INTO "+FinalBD.T_CLIENTE+"("+
                                    FinalBD.TC_NOMBRE+","+
                                    FinalBD.TC_CEDULA+","+
                                    FinalBD.TC_TARJETA+","+
                                    FinalBD.TC_EMAIL+") VALUES(?,?,?,?)";
        try {
            Connection connection= getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCedula());
            ps.setString(3, cliente.getTarjeta());
            ps.setString(4, cliente.getEmail());
            ps.executeUpdate();
            
            System.out.println("Cliente creado correctamente");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error  al crear el cliente "+e);            
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
    public Cliente getCliente(String cedula) {
       
         String sql="SELECT * "+
                    " FROM "+FinalBD.T_CLIENTE+
                    " WHERE "+FinalBD.T_CLIENTE+"."+FinalBD.TC_CEDULA+" = '"+cedula+"'";
         
         try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            Cliente cliente = new Cliente();  
           
            while(resultSet.next()) {  

            cliente.setId(resultSet.getInt(FinalBD.TC_ID));
            cliente.setNombre(resultSet.getString(FinalBD.TC_NOMBRE));
            cliente.setCedula(resultSet.getString(FinalBD.TC_CEDULA));
            cliente.setTarjeta(resultSet.getString(FinalBD.TC_TARJETA));
            cliente.setEmail(resultSet.getString(FinalBD.TC_EMAIL));

            }  
             return cliente; 
            
            
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
    
}
