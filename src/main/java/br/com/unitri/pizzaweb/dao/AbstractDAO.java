package br.com.unitri.pizzaweb.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public abstract class AbstractDAO<T, I extends Serializable> implements DAO<T, I> {

	@Inject
	protected EntityManager manager;

	@Override
	public T persist(T entity) {
		T saved = null;

		manager.getTransaction().begin();
		saved = manager.merge(entity);
		manager.getTransaction().commit();

		return saved;
	}

	@Override
	public T update(T entity) {
		T saved = null;

		manager.getTransaction().begin();
		saved = manager.merge(entity);
		manager.getTransaction().commit();

		return saved;
	}

	@Override
	public void remove(T entity) {
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
	}

	@Override
	public T getById(Class<T> clazz, I pk) {
		try {
			return manager.find(clazz, pk);
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> clazz) {
		return manager.createQuery("select o from " + clazz.getSimpleName() + " o").getResultList();
	}
}
