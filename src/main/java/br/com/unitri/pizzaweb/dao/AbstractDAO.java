package br.com.unitri.pizzaweb.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public abstract class AbstractDAO<T, I extends Serializable> implements DAO<T, I> {

	Connection connection;

	@Override
	public T persist(T entity) {
		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	@Override
	public T update(T entity) {
		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	@Override
	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public T getById(Class<T> clazz, I pk) {
		try {
			return getEntityManager().find(clazz, pk);
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> clazz) {
		return getEntityManager().createQuery("select o from " + clazz.getSimpleName() + " o").getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		if (connection == null) {
			connection = new Connection();
		}
		return connection.getEntityManager();
	}
}
