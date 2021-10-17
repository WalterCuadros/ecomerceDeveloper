package com.ecommerce.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ecommerce.controller.carritoController;
import com.ecommerce.modelos.Carrito;
import com.ecommerce.modelos.Cliente;
import com.ecommerce.modelos.ProductoCarritoVista;
import com.ecommerce.modelos.ProductoVista;
@ManagedBean
@SessionScoped
public class carritoBean {
	private ProductoVista productoVista;
	private Cliente cliente;
	private Carrito carrito;
	carritoController carritoController =  new carritoController();
	
	public String guardarProductoCarrito(ProductoVista productoVista , Cliente cliente ) {
		this.carritoController.setProductoVista(productoVista);
		this.carritoController.setCliente(cliente);
		this.carrito = carritoController.agregarProductoCarrito();
		return "storeOne";
		
	}
	public ArrayList<ProductoCarritoVista> mostrarCarrito(){
		return carritoController.mostrarCarrito();
	}
	public String viewCarrito(){
		return "carrito";
	}
}
