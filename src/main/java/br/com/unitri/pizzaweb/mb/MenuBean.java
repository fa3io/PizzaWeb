package br.com.unitri.pizzaweb.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.com.unitri.pizzaweb.entity.Pizza;
import br.com.unitri.pizzaweb.interfaces.PizzaSessionBeanRemote;




@ManagedBean
@SessionScoped
public class MenuBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Pizza> pizzas;
	private Pizza pizza = new Pizza();
	
	@EJB
	PizzaSessionBeanRemote pizzaSession;
	
	public MenuBean() {
		carregarPizzas();
		
		
	}
	
	public String pedir(Integer codigo){
			setPizza(pizzas.get(1));
			pizzaSession.solicitrPedido("Pedido: " + pizza.getNome());
			return "detalhe.jsf";
	}
	
	
    private void carregarPizzas(){
    	pizzas = new ArrayList<>();
    	
    	pizzas.add(new Pizza(1,"calabresa.jpg", "Calabresa", "Pizza de Calabresa ", new BigDecimal("40.00")));
    	pizzas.add(new Pizza(2,"mussarela.jpg", "Mussarela", "Pizza de Mussarela ", new BigDecimal("35.00")));
    	pizzas.add(new Pizza(3,"portuguesa.jpg", "Portuguesa", "Pizza de Portuguesa ", new BigDecimal("50.00")));
    }


	/**
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}


	/**
	 * @param pizzas the pizzas to set
	 */
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
}
