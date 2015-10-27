package br.com.unitri.pizzaweb.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.unitri.pizzaweb.entity.Cliente;
import br.com.unitri.pizzaweb.entity.Ingrediente;
import br.com.unitri.pizzaweb.entity.Pedido;
import br.com.unitri.pizzaweb.entity.Pizza;
import br.com.unitri.pizzaweb.impl.PizzaJMS;
import br.com.unitri.pizzaweb.interfaces.PizzaSessionBeanRemote;

@SessionScoped
@Named
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Pizza> pizzas = new ArrayList<>();
	Pizza pizza = new Pizza();
	List<String> ingredientesSelecionados = new ArrayList<>();
	List<Ingrediente> ingredientes = new ArrayList<>();

	@EJB
	private PizzaSessionBeanRemote pizzaSession;

	PizzaJMS pizzaJMS = new PizzaJMS();

	private Pedido pedido;

	public MenuBean() {

	}

	@PostConstruct
	public void init() {
		carregarPizzas();
	}

	public String selecionar(Integer codigo) {
		setPizza(pizzas.get(codigo));
		return "detalhe.jsf";
	}

	public void pedir() {
		Cliente cliente = getUsuarioSessao();
		pedido = montarPedido(pizza, cliente, ingredientes);
		pizzaJMS.solicitrPedido(pedido);
	}

	private Pedido montarPedido(Pizza pizza, Cliente cliente, List<Ingrediente> ingredientes) {
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPizza(pizza);
		pedido.setIngredientes(ingredientes);
		return pedido;
	}

	private Cliente getUsuarioSessao() {
		Cliente cliente = null;

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		cliente = (Cliente) session.getAttribute("cliente");
		
		return cliente;
	}

	private void carregarPizzas() {
		pizzas.addAll(pizzaSession.getAll());
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public List<String> getIngredientesSelecionados() {
		return ingredientesSelecionados;
	}

	public void setIngredientesSelecionados(List<String> ingredientesSelecionados) {
		this.ingredientesSelecionados = ingredientesSelecionados;
	}
}
