package com.cc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cc.persistencia.VendaPorDia;

public class VendaPorDiaDao implements Dao<VendaPorDia>{

  private EntityManager entityManager;

  public VendaPorDiaDao(EntityManager entityManager) {
    this.entityManager = entityManager;
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
	
	@SuppressWarnings("unchecked")
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
