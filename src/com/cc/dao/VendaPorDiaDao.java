package com.cc.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cc.persistencia.Mes;
import com.cc.persistencia.VendaPorDia;

public class VendaPorDiaDao implements Dao<VendaPorDia>{

  private EntityManager entityManager;

  public VendaPorDiaDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

	public void incluir(VendaPorDia vendaPorDia) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(vendaPorDia.getMes());
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
			VendaPorDia venda = entityManager.find(VendaPorDia.class, vendaPorDia.getId());

			entityManager.remove(venda);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}
	
	//Extrair após consolidação do sistema 
	@SuppressWarnings("unchecked")
	public Mes mesAtual(){
 		java.util.Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int mesAtual = cal.get(Calendar.MONTH) +1;
		List<Mes> meses = entityManager.createQuery("select m from " + Mes.class.getName()+" m ").getResultList();
		for (Mes mes : meses) {
			if(mes.getMes() != null && mes.getMes() == mesAtual){
				return mes;
			}
		}
		
		return new Mes(); 
	}
	
	public double totalMesAtual(){
		java.util.Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int mesAtual = cal.get(Calendar.MONTH) +1;
		Query q = entityManager.createQuery("FROM VendaPorDia v where v.mes.mes = :mes and v.valorVenda is not null" );
		q.setParameter("mes", mesAtual);
		List<VendaPorDia> vendas = q.getResultList();
		
		if(vendas.size() > 0){
			double total = 0;
			for (VendaPorDia vendaPorDia : vendas) {
				total = vendaPorDia.getValorVenda() + total;
			}
			return vendas.get(0).getMes().getValorCota() - total;
		}
		
		return 0;
	}
	
}
