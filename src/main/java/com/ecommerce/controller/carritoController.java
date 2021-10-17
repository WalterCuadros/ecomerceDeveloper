package com.ecommerce.controller;

import java.util.ArrayList;

import com.ecommerce.dao.DaoCarrito;
import com.ecommerce.dao.DaoProducto;
import com.ecommerce.dao.DaoProductoCarrito;
import com.ecommerce.dao.IDaoCarrito;
import com.ecommerce.dao.IDaoProducto;
import com.ecommerce.dao.IDaoProductoCarrito;
import com.ecommerce.modelos.Carrito;
import com.ecommerce.modelos.Cliente;
import com.ecommerce.modelos.ProductoCarrito;
import com.ecommerce.modelos.ProductoCarritoVista;
import com.ecommerce.modelos.ProductoVista;

public class carritoController {
	private ProductoVista productoVista;
	private Carrito carrito;
	private IDaoCarrito IDaocarrito = new DaoCarrito();
	private IDaoProducto IDaoproducto = new DaoProducto();
	private IDaoProductoCarrito IDaoproductoCarrito = new DaoProductoCarrito();
	private Cliente cliente;
	
	public carritoController() {
	}
	
	
    public ProductoVista getProductoVista() {
		return productoVista;
	}


	public void setProductoVista(ProductoVista productoVista) {
		this.productoVista = productoVista;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Carrito agregarProductoCarrito(){
    	try{ 
		        String codigoBarras = this.productoVista.getCodigoBarras();
		        if(!codigoBarras.equals("")){
		            this.carrito = buscarCarrito();
		            if(this.carrito == null){
		                this.carrito = crearCarrito();
		            }
	
		            ProductoCarrito productoCarritoGuardar = new ProductoCarrito();
		            productoCarritoGuardar.setCantidadProducto(1);
		            productoCarritoGuardar.setProductoId(IDaoproducto.getProducto(codigoBarras).getId());
		            productoCarritoGuardar.setCarritoId(this.carrito.getId());
		            productoCarritoGuardar.setInCarrito(true);
		            IDaoproductoCarrito.crearProductoCarrito(productoCarritoGuardar);
		        }
		        return this.carrito;
    	} catch (NumberFormatException e) {
            	return null;
        }
	        
	 }
	 
	 private Carrito buscarCarrito(){
         
         Carrito carritoBuscado = IDaocarrito.getCarrito(this.cliente.getCedula(), true);
         return (carritoBuscado.getId() == 0)? null: carritoBuscado;
    
     }

	 private Carrito crearCarrito(){
	        
	        Carrito carritoCrear = new Carrito();
	        carritoCrear.setClienteId(this.cliente.getId());
	        carritoCrear.setActive(true);
	        IDaocarrito.crearCarrito(carritoCrear);
	        carritoCrear = IDaocarrito.getCarrito(this.cliente.getCedula(), true);
	        return carritoCrear;
	}
	public ArrayList<ProductoCarritoVista> mostrarCarrito(){
		 ArrayList<ProductoCarritoVista> listaProductoCarrito = IDaoproductoCarrito.visualizarProductoCarrito(this.cliente.getCedula(),0, true, false);
		 return  listaProductoCarrito;
	} 
}
