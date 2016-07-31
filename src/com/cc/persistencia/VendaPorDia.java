package com.cc.persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cc.util.Util;

@Entity
@Table
public class VendaPorDia {

	@Id
	@GeneratedValue
	@Column(name = "venda_dia_id")
	private Long id;
	private Double valorVenda;
	private Date data;
	private String dataFormatada;
	
	@ManyToOne
	private Mes mes;

	public VendaPorDia() {
	}
	
	public VendaPorDia(Long id) {
		super();
		this.id = id;
	}
	
	public VendaPorDia(String id) {
		super();
		this.id = Long.parseLong(id);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDataFormatada(){
		if(data!= null){
			DateFormat dateTime = new SimpleDateFormat("dd/MM/aaaa");
			String dateStr = dateTime.format(data);
			return dateStr;
		}
		return "";

	}

}
