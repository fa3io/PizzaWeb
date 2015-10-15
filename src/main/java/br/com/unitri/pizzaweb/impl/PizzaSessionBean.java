package br.com.unitri.pizzaweb.impl;

import javax.ejb.Stateless;

import br.com.unitri.pizzaweb.entity.Pizza;
import br.com.unitri.pizzaweb.interfaces.PizzaSessionBeanRemote;

/**
 * Session Bean implementation class PizzaSessionBean
 */
@Stateless
public class PizzaSessionBean implements PizzaSessionBeanRemote {

    /**
     * Default constructor. 
     */
    public PizzaSessionBean() {
    }
    
    @Override
    public void solicitrPedido(String pedido){
    	System.out.println(pedido);
    }

	@Override
	public void salvar(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPorId(Pizza id) {
		// TODO Auto-generated method stub
		
	}
}
