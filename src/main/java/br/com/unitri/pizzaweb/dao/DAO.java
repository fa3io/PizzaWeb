package br.com.unitri.pizzaweb.dao;

import java.io.Serializable;
import java.util.List;

interface DAO<T,I extends Serializable>{
	
	  T persist(T entity);
	  T update(T entity);
	  void remove(T entity);
	  T getById(Class<T> clazz, I pk);
	  List<T> getAll(Class<T> clazz);
	}
