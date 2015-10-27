package br.com.unitri.pizzaweb.interfaces;

import java.util.List;

import javax.ejb.Remote;

import br.com.unitri.pizzaweb.entity.Pizza;

@Remote
public interface PizzaSessionBeanRemote {
	
	 void salvar(Pizza pizza);
		
	 void atualizar(Pizza pizza);
	
	 void deletar(Pizza pizza);
	 
	 Pizza buscarPorId(Integer id);
	 
	 List<Pizza> getAll();
}
