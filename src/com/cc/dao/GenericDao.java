package com.cc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.cc.persistencia.Cliente;

public class GenericDao implements Dao<Cliente>{
  
  
  public GenericDao() {
  }
  
  @Override
  public void incluir(Cliente t) {
    try {
      entityManager.getTransaction().begin(); 
      entityManager.persist(t);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }
  
  public List<Cliente> listarTodas() {
    return entityManager.createQuery("FROM " + classePersistida.getClass().getName()).getResultList();
  }
  
  public void excluir(T t) {
    try {
      entityManager.getTransaction().begin();
      cliente = entityManager.find(classePersistida.getClass(), t.getId()); //essa busca é necessária?????
      entityManager.remove(t);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    
  }

  @Override
  public void incluir(T t) {
    // TODO Auto-generated method stub
    
  }

}
