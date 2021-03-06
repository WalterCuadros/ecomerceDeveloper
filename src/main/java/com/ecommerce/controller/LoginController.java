package com.ecommerce.controller;

import com.ecommerce.modelos.Cliente;
import com.ecommerce.dao.IDaoCliente;

public class LoginController {
	private String cedula;
	private Cliente cliente;
	private IDaoCliente IDaocliente;
	
	public LoginController(Cliente cliente, IDaoCliente IDaocliente) {
		this.cliente = cliente;
		this.IDaocliente = IDaocliente;
	}
	 public Cliente loginAction(String cedula,String password){
	        if(!cedula.equals("")){
	            this.cliente = buscarCliente(cedula,password);
	            System.out.println(this.cliente);
	            if(this.cliente == null){
	                return null;
	                
	            }else{
	               return this.cliente;
	            }
	       
	        }else{
	        	return null;
	        }
	    } 
	    
	 private Cliente buscarCliente(String cedula, String password ){
	        
	        Cliente clienteBuscado = IDaocliente.getCliente(cedula, password); 
	        System.out.println(cedula);
	        System.out.println("Cliente buscado");
	        System.out.println(clienteBuscado.getId());
	        return (clienteBuscado.getId() == 0)? null: clienteBuscado;
	    }
}
