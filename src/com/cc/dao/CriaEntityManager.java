package com.cc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaEntityManager {

  private static EntityManager entityManager;
  
  public static EntityManager getEntityManager(){
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnitFabio");
    if(entityManager == null){
      entityManager = factory.createEntityManager();
    }
    return entityManager;
  }
}