package br.com.unitri.pizzaweb.impl;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unitri.pizzaweb.entity.Pedido;

@Named
public class PizzaJMS {
	
	@Resource(mappedName = "java:/queue/pizzaQueue")
	private Queue pizzaQueue;

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext context;

	ObjectMapper mapper;
	
	 public void solicitrPedido(Pedido pedido){
		 String pedidoJson = "";
			mapper = new ObjectMapper();
			try {
				pedidoJson = mapper.writeValueAsString(pedido);
				System.out.println(pedidoJson);
				ObjectMessage objMessage = context.createObjectMessage();
				objMessage.setObject(pedidoJson);
				context.createProducer().send(pizzaQueue, pedidoJson);
			} catch (JsonProcessingException e) {
			
			} catch (JMSException e) {
				
			}
	 }

}
