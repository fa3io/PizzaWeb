package br.com.webpizza.interfaces;

import javax.ejb.Remote;

@Remote
public interface PizzaSessionBeanRemote {
	
	 public void solicitrPedido(String pedido);
	    	

}
