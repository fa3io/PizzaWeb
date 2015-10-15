package br.com.unitri.pizzaweb.interfaces;

import javax.ejb.Remote;

import br.com.unitri.pizzaweb.entity.Pizza;

@Remote
public interface PizzaSessionBeanRemote {
	
	 void salvar(Pizza pizza);
		
	 void atualizar(Pizza pizza);
	
	 void deletar(Pizza pizza);
	 
	 void buscarPorId(Pizza id);
	 
	 void solicitrPedido(String pedido);
	 
	 
	    	

}
