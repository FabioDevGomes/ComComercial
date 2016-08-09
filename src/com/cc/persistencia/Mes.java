package com.cc.persistencia;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Mes {

	@Id
	@GeneratedValue
	private long id;
	private Integer mes;
	private double valorCota;
	private int qtdDiasFolga;
	
	@OneToMany( mappedBy="mes", targetEntity = VendaPorDia.class)
	private List<VendaPorDia> vendas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValorCota() {
		return valorCota;
	}

	public void setValorCota(double valorCota) {
		this.valorCota = valorCota;
	}

	public List<VendaPorDia> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaPorDia> vendas) {
		this.vendas = vendas;
	}

	public int getQtdDiasFolga() {
		return qtdDiasFolga;
	}

	public void setQtdDiasFolga(int qtdDiasFolga) {
		this.qtdDiasFolga = qtdDiasFolga;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

}
