package br.com.unitri.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	private static final String PERSISTENCE_UNIT_NAME = "PizzaWeb";
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public EntityManager getEntityManager() {

		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}
}