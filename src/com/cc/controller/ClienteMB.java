package com.cc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.cc.dao.ClienteDao;
import com.cc.persistencia.Cliente;

@ManagedBean(name = "clienteMB")
public class ClienteMB {
	
	private Cliente cliente; 
	private List<Cliente> listaClientes;
	private ClienteDao clienteDao;
	
	public ClienteMB() {
		clienteDao = new ClienteDao();
		estadoInicial();
	}
	
	private void estadoInicial(){
		cliente = new Cliente();
		listar();
	}
	
	
	public void listar(){
		listaClientes = clienteDao.listarTodas();
	}
	
	public void incluir(){
		Cliente cliente = getCliente();
		clienteDao.incluir(cliente);
		estadoInicial();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Controle de Clientes:", 
						"Cliente incluído com sucesso!"));
	}
	
	public void excluir(String id){
		Cliente cliente = new Cliente(id);
		clienteDao.excluir(cliente);
		estadoInicial();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Controle de Clientes:", 
						"Cliente Excluído com sucesso!"));
	}
	
	
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
