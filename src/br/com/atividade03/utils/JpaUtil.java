package br.com.atividade03.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistAtividade03");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}