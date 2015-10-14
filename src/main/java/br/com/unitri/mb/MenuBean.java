package br.com.unitri.mb;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.unitri.entity.Pizza;
import br.com.webpizza.interfaces.PizzaSessionBeanRemote;




@ManagedBean
@RequestScoped
public class MenuBean {
	
	private List<Pizza> pizzas;
	private Pizza pizza;
	
	@EJB
	PizzaSessionBeanRemote pizzaSession;
	
	public MenuBean() {
		carregarPizzas();
	}
	
	public void pedir(Integer codigo){
		try {
			setPizza(pizzas.get(1));
			pizzaSession.solicitrPedido("Pedido: " + pizza.getNome());
			FacesContext.getCurrentInstance().getExternalContext().redirect("detalhe.jsf");
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Carregar Pizza", "Erro"));
		}
	}
	
	
    private void carregarPizzas(){
    	pizzas = new ArrayList<>();
    	
    	pizzas.add(new Pizza(1,"img/calabresa.jpg", "Calabresa", "Pizza de Calabresa ", new BigDecimal("40.00")));
    	pizzas.add(new Pizza(2,"img/mussarela.jpg", "Mussarela", "Pizza de Mussarela ", new BigDecimal("35.00")));
    	pizzas.add(new Pizza(3,"img/portuguesa.jpg", "Portuguesa", "Pizza de Portuguesa ", new BigDecimal("50.00")));
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
