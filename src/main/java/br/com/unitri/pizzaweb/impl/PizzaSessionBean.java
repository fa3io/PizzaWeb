package br.com.unitri.pizzaweb.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unitri.pizzaweb.entity.Pedido;
import br.com.unitri.pizzaweb.entity.Pizza;
import br.com.unitri.pizzaweb.interfaces.PizzaSessionBeanRemote;

/**
 * Session Bean implementation class PizzaSessionBean
 */
@Stateless
public class PizzaSessionBean implements PizzaSessionBeanRemote {

	@Resource(mappedName = "jms/queue/pizza") 
	private Queue Pizzaqueue;
	
	@Inject
	JMSContext context;
	
	ObjectMapper mapper;
	
	
	
    public PizzaSessionBean() {
    }
    
    @Override
    public void solicitrPedido(Pedido pedido){
    	String PedidoJson = "";
    	mapper = new ObjectMapper();
		try {
			PedidoJson = mapper.writeValueAsString(pedido);
			System.out.println(PedidoJson);
			context.createProducer().send(Pizzaqueue, PedidoJson);
		} catch (JsonProcessingException e) {
			
		}
    	
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
