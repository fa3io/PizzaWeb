package br.com.unitri.pizzaweb.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.unitri.pizzaweb.entity.Cliente;
import br.com.unitri.pizzaweb.entity.Ingrediente;
import br.com.unitri.pizzaweb.entity.Pedido;
import br.com.unitri.pizzaweb.entity.Pizza;
import br.com.unitri.pizzaweb.interfaces.PizzaSessionBeanRemote;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Pizza> pizzas;
	private Pizza pizza = new Pizza();
	Cliente cliente = new Cliente();
	List<Ingrediente> ingredientes = new ArrayList<>();

	@EJB
	PizzaSessionBeanRemote pizzaSession;

	@Inject
	Pedido pedido;

	public MenuBean() {
		carregarPizzas();

	}

	public String selecionar(Integer codigo) {
		setPizza(pizzas.get(codigo));
		return "detalhe.jsf";
	}

	public void pedir() {
		pedido = montarPedido(pizza, cliente, ingredientes);
		pizzaSession.solicitrPedido(pedido);
	}

	private Pedido montarPedido(Pizza pizza2, Cliente cliente2, List<Ingrediente> ingredientes2) {

		return null;
	}

	private void carregarPizzas() {
		pizzas = new ArrayList<>();

		pizzas.add(new Pizza(1, "calabresa.jpg", "Calabresa", "Pizza de Calabresa ", new BigDecimal("40.00")));
		pizzas.add(new Pizza(2, "mussarela.jpg", "Mussarela", "Pizza de Mussarela ", new BigDecimal("35.00")));
		pizzas.add(new Pizza(3, "portuguesa.jpg", "Portuguesa", "Pizza de Portuguesa ", new BigDecimal("50.00")));
	}

	/**
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * @param pizzas
	 *            the pizzas to set
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
