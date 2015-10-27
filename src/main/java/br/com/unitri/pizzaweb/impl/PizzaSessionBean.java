package br.com.unitri.pizzaweb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.unitri.pizzaweb.dao.PizzaDAO;
import br.com.unitri.pizzaweb.entity.Pizza;
import br.com.unitri.pizzaweb.interfaces.PizzaSessionBeanRemote;

/**
 * Session Bean implementation class PizzaSessionBean
 */
@Stateless
public class PizzaSessionBean implements PizzaSessionBeanRemote {

	@Inject
	PizzaDAO pizzaDAO;

	public PizzaSessionBean() {
	}

	@Override
	public void salvar(Pizza pizza) {
		pizzaDAO.persist(pizza);
	}

	@Override
	public void atualizar(Pizza pizza) {
		pizzaDAO.update(pizza);
	}

	@Override
	public void deletar(Pizza pizza) {
		pizzaDAO.remove(pizza);
	}

	@Override
	public Pizza buscarPorId(Integer id) {
		return pizzaDAO.getById(Pizza.class, id);
	}

	@Override
	public List<Pizza> getAll() {
		return pizzaDAO.getAll(Pizza.class);
	}

}
