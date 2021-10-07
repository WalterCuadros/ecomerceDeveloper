package com.ecommerce.bean;

import java.awt.event.ActionEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ecommerce.controller.LoginController;
import com.ecommerce.controller.SessionUtils;
import com.ecommerce.dao.DaoCliente;
import com.ecommerce.dao.IDaoCliente;
import com.ecommerce.modelos.Cliente;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class loginBean {
	private String cedula;
	private String password;
	private Cliente cliente = new Cliente();
	private IDaoCliente IdaoCliente = new DaoCliente();
	private LoginController login = new LoginController(this.cliente, this.IdaoCliente);
	private String mensaje ="";
	private HttpSession session = SessionUtils.getSession();
	public String getNombre() {
		return this.cliente.getNombre();
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String validarFormulario() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(getCedula().equals("")) {
			context.addMessage(null, new FacesMessage("Campo Cédula es obligatorio"));
		}else {
			this.cliente = this.login.loginAction(this.cedula);
			if(this.cliente != null) {
				this.session.setAttribute("username", this.cliente.getNombre());
				this.session.setAttribute("userid", this.cliente.getId());
				return "storeOne";
			}
		}
		return "login";
	
	}
	public String validarSesion() {
		System.out.println(this.session.getAttribute("username"));
		if(this.session.getAttribute("username") == null) {
			return "login";
		}else {
			return null;
		}
	}
	public String cerrarSesion() {
		 this.cliente = null;
		this.session.invalidate();
		 return "login";
	 }
}
