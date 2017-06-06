package br.com.fiap.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistency-Final");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}