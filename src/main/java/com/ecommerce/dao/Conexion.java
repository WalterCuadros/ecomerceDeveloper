package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.cj.jdbc.Driver;

public class Conexion {
	
	 private Connection connection=null;
	    
	    public Connection getConexion(){
	        
	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection=DriverManager.getConnection(FinalBD.URL+FinalBD.DATABASE, FinalBD.USER, FinalBD.PASSWORD);
	            
	        } catch (SQLException e) {
	            System.out.println("Error al conectar a la base de datos "+e.getMessage());
	        }catch(ClassNotFoundException ex){
	            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return connection;
	    }
}
