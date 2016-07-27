package com.cc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.cc.dao.ClienteDao;
import com.cc.dao.VendaPorDiaDao;
import com.cc.persistencia.Cliente;
import com.cc.persistencia.Mes;
import com.cc.persistencia.VendaPorDia;

@ManagedBean(name = "vendaPorDiaMB")
public class VendaDiaMB {
	
	private VendaPorDia vendaPorDia; 
	private Mes mes;
	private List<VendaPorDia> listaVendas;
	private VendaPorDiaDao vDao;
	
	public VendaDiaMB() {
		vDao = new VendaPorDiaDao();
		mes = new Mes();
		estadoInicial();
	}
	
	private void estadoInicial(){
		vendaPorDia = new VendaPorDia();
		listar();
	}
	
	
	public void listar(){
		listaVendas = vDao.listarTodas();
	}
	
	public void incluir(){
		VendaPorDia venda = getVendaPorDia();
		venda.setMes(getMes());
		vDao.incluir(venda);
		estadoInicial();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Controle de VendaPorDias:", 
						"Cliente incluído com sucesso!"));
	}
	
	public void excluir(String id){
		VendaPorDia cliente = new VendaPorDia(id);
		vDao.excluir(cliente);
		estadoInicial();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Controle de Clientes:", 
						"Cliente Excluído com sucesso!"));
	}

	public VendaPorDia getVendaPorDia() {
		return vendaPorDia;
	}

	public void setVendaPorDia(VendaPorDia vendaPorDia) {
		this.vendaPorDia = vendaPorDia;
	}

	public List<VendaPorDia> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(List<VendaPorDia> listaVendas) {
		this.listaVendas = listaVendas;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
	
	

}
