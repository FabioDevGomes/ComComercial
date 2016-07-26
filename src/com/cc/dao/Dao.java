package com.cc.dao;

import java.util.List;

import com.cc.persistencia.Cliente;


public interface Dao<T> {
	
	void incluir(T t);
	List<T> listarTodas();
	
}
