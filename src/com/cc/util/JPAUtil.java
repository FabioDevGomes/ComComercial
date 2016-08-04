package com.cc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

  private static EntityManager entityManager;
  
  public static EntityManager getEntityManager(){
    if(entityManager == null){
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnitFabio");
    	entityManager = factory.createEntityManager();
    }
    return entityManager;
  }
}