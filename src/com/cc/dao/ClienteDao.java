package com.cc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cc.persistencia.Cliente;
import com.cc.util.JPAUtil;

public class ClienteDao implements Dao<Cliente>{

protected EntityManager entityManager;
	
	public ClienteDao() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	public void incluir(Cliente cliente) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
  public List<Cliente> listarTodas() {
		return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}
	
	public void excluir(Cliente cliente) {
		try {
			entityManager.getTransaction().begin();
			cliente = entityManager.find(Cliente.class, cliente.getId());
			entityManager.remove(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

}
