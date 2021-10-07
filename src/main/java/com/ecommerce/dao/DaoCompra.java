/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelos.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class DaoCompra extends Conexion implements IDaoCompra {

    @Override
    public boolean agregarCompra(Compra compra) {
      String sql="INSERT INTO "+FinalBD.T_COMPRA+"("+
                                    FinalBD.TCOM_VALOR_OBSEQUIO+","+
                                    FinalBD.TCOM_VALOR_TOTAL+","+
                                    FinalBD.TCOM_CARRITO_ID+") VALUES(?,?,?)";
        try {
            Connection connection= getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setFloat(1, compra.getValorObsequio());
            ps.setFloat(2, compra.getValorTotal());
            ps.setInt(3, compra.getCarritoId());
            ps.executeUpdate();
            
            System.out.println("Compra registrada correctamente");
           
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
    public ArrayList<Compra> getCompras(String cedula) {
        ArrayList<Compra> arrayListCompras =new ArrayList<>();
         String sql="SELECT * FROM "+FinalBD.T_COMPRA+
                    " JOIN "+FinalBD.T_CARRITO+
                    " ON "+FinalBD.T_COMPRA+"."+FinalBD.TCOM_CARRITO_ID+" = "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_ID+
                    " JOIN "+FinalBD.T_CLIENTE+
                    " ON "+FinalBD.T_CARRITO+"."+FinalBD.TCAR_CLIENTE_ID+" = "+FinalBD.T_CLIENTE+"."+FinalBD.TC_ID+
                    " WHERE "+FinalBD.T_CLIENTE+"."+FinalBD.TC_CEDULA+" = '"+cedula+"'";
         try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()) {  

                Compra compra = new Compra();
                compra.setId(resultSet.getInt(FinalBD.TCOM_ID));
                compra.setValorTotal(resultSet.getFloat(FinalBD.TCOM_VALOR_TOTAL));
                compra.setValorObsequio(resultSet.getFloat(FinalBD.TCOM_VALOR_OBSEQUIO));
                
                arrayListCompras.add(compra);
          }
            return arrayListCompras;
        } catch(SQLException e) {
            System.out.println("Error al leer los datos "+e);
            return null;           
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
       
    }
    
}
