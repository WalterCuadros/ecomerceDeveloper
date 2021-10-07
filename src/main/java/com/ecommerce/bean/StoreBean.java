package com.ecommerce.bean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ecommerce.controller.LoginController;
import com.ecommerce.controller.SessionUtils;
import com.ecommerce.dao.DaoCliente;
import com.ecommerce.dao.DaoProducto;
import com.ecommerce.dao.IDaoCliente;
import com.ecommerce.dao.IDaoProducto;
import com.ecommerce.modelos.Cliente;
import com.ecommerce.modelos.Producto;
import com.ecommerce.modelos.ProductoVista;

@ManagedBean
@SessionScoped
public class StoreBean {
	private IDaoProducto IDaoproducto = new DaoProducto();
	private String texto;
	private List<ProductoVista> productos;
	public StoreBean () {
	}

	public List<ProductoVista> getProductos(Integer opcion){
		
		this.productos = IDaoproducto.traerProductos(opcion, false);
		return this.productos;
		
	}
	
	public String goProductos(Integer categoria) {
		switch(categoria) {
		case 1:  return "storeOne";
        		
		case 2:  return "storeTwo";
		
		case 3:  return "storeThree";
		
		default: return "login";
		}
	}
	public void agregaraCarrito(Integer idProducto) {
		System.out.println("Su producto tiene id:"+ idProducto);
	}
		
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
