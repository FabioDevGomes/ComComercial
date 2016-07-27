package com.cc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cc.persistencia.Cliente;
import com.cc.persistencia.VendaPorDia;

public class VendaPorDiaDao implements Dao<VendaPorDia>{

protected EntityManager entityManager;
	
	public VendaPorDiaDao() {
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnitFabio");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public void incluir(VendaPorDia vendaPorDia) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(vendaPorDia);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public List<VendaPorDia> listarTodas() {
		return entityManager.createQuery("FROM " + VendaPorDia.class.getName()).getResultList();
	}
	
	public void excluir(VendaPorDia vendaPorDia) {
		try {
			entityManager.getTransaction().begin();
			vendaPorDia = entityManager.find(VendaPorDia.class, vendaPorDia.getId());
			entityManager.remove(vendaPorDia);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

}
