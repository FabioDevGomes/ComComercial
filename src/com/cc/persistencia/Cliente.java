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
public class Cliente {

	
	@Id
	@GeneratedValue
	@Column(name="cliente_id")
	private Long id;
	private String nome;
	private String observacoes;
	private String telefone;
	private Integer avaliacaoo;
	private Date dataCadastro;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private List<Compra> compras;
	
	
	public Cliente() {
	}
	
	public Cliente(Long id) {
		super();
		this.id = id;
	}

	public Cliente(String id) {
		super();
		this.id = Long.parseLong(id);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Integer getAvaliacaoo() {
		return avaliacaoo;
	}
	public void setAvaliacaoo(Integer avaliacaoo) {
		this.avaliacaoo = avaliacaoo;
	}
	
	
	
	
}
