package com.cc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cc.persistencia.Cliente;

public class ClienteDao {

protected EntityManager entityManager;
	
	public ClienteDao() {
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnitFabio");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
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
	
	public List<Cliente> listarTodas() {
		return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}

}
