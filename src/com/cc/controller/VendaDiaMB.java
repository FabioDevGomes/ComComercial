package com.cc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.cc.dao.VendaPorDiaDao;
import com.cc.persistencia.Mes;
import com.cc.persistencia.VendaPorDia;
import com.cc.util.JPAUtil;
import com.cc.util.Util;

@ManagedBean(name = "vendaPorDiaMB")
public class VendaDiaMB {
	
	private VendaPorDia vendaPorDia; 
	private Mes mes;
	private List<VendaPorDia> listaVendas;
	private VendaPorDiaDao vDao;
	private Double media;
	private Double meta;
	
	public VendaDiaMB() {
		//Proposta de Decisão de design
		vDao = new VendaPorDiaDao(JPAUtil.getEntityManager());
		mes = vDao.mesAtual();
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
						"Cliente inclu�do com sucesso!"));
	}
	
	public void excluir(String id){
		VendaPorDia cliente = new VendaPorDia(id);
		vDao.excluir(cliente);
		estadoInicial();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Controle de Cota:", 
						"Excluído com sucesso!"));
	}
	
	public double getMeta(){
		java.util.Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int quantidadeDeDias = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int totalDiaMes = quantidadeDeDias - mes.getQtdDiasFolga();
		double meta = mes.getValorCota() / totalDiaMes;
		
		return meta;
	}
	
	
	public double getRestanteCota(){
		return vDao.totalMesAtual();
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

	public Double getMedia() {
		return media;
	}

}
