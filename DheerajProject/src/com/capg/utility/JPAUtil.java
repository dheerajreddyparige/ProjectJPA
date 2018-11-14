package com.capg.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	/*static {
		factory = 
			Persistence.createEntityManagerFactory("DheerajProject");
	}
	*/
	public static EntityManager getEntityManager() {
		/*if(entityManager==null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;*/
		return Persistence.createEntityManagerFactory("DheerajProject").createEntityManager();
	}
	
}
