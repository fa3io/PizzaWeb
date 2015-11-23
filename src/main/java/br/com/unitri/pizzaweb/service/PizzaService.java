package br.com.unitri.pizzaweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.unitri.pizzaweb.dao.PizzaDAO;
import br.com.unitri.pizzaweb.entity.Pizza;

@Path("/pizza")
@Stateless
public class PizzaService {
	
	@Inject
	private PizzaDAO pizzaDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/todos")
	public List<Pizza> listAll() {
		return pizzaDAO.getAll(Pizza.class);
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") Integer id) {
		Pizza pizza = pizzaDAO.getById(Pizza.class, id );
		if (pizza == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		System.out.println("findById " + id + ": found contato = " + pizza);
		return Response.ok(pizza).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public Response createPizza(Pizza pizza) {
		System.out.println("Criando Pizza = " + pizza);
		Response.ResponseBuilder builder = null;
		try {

			pizzaDAO.persist(pizza);
			builder = Response.ok().entity(pizza);
			System.out.println("Criacao de Pizza  = " + pizza);

		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());

			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updatePizza(Pizza pizza) {
		System.out.println("Atualizacao de Pizza = " + pizza);
		Response.ResponseBuilder builder = null;
		try {

			pizzaDAO.update(pizza);

			builder = Response.ok().entity(pizza);
			System.out.println("Atualizacao completa de pizza = " + pizza);
		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());
			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/excluir")
	public Response deletePizza(Pizza pizza) {
		System.out.println("Delecao de Pizza = " + pizza);
		Response.ResponseBuilder builder = null;

		try {
			if (pizza.getId() != null) {
				pizzaDAO.remove(pizza);
			} else {
				System.out.println("Não foi encontrado pizza para ser deletada");
			}
			builder = Response.ok().entity(pizza);
			System.out.println("Delecao efetuada com sucesso = " + pizza);
		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());

			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
	}
	
	
}
