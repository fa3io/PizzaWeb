package br.com.webpizza.impl;

import javax.ejb.Stateless;

import br.com.webpizza.interfaces.PizzaSessionBeanRemote;

/**
 * Session Bean implementation class PizzaSessionBean
 */
@Stateless
public class PizzaSessionBean implements PizzaSessionBeanRemote {

    /**
     * Default constructor. 
     */
    public PizzaSessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void solicitrPedido(String pedido){
    	System.out.println(pedido);
    }

}
