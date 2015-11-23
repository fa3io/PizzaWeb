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

import br.com.unitri.pizzaweb.dao.ClienteDAO;
import br.com.unitri.pizzaweb.entity.Cliente;

@Path("/cliente")
@Stateless
public class ClienteService {
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/todos")
	public List<Cliente> listAll() {
		return clienteDAO.getAll(Cliente.class);
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") Integer id) {
		Cliente cliente = clienteDAO.getById(Cliente.class, id );
		if (cliente == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		System.out.println("findById " + id + ": found contato = " + cliente);
		return Response.ok(cliente).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public Response createCliente(Cliente cliente) {
		System.out.println("Criando Cliente = " + cliente);
		Response.ResponseBuilder builder = null;
		try {

			clienteDAO.persist(cliente);
			builder = Response.ok().entity(cliente);
			System.out.println("Criacao de Cliente  = " + cliente);

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
	public Response updateCliente(Cliente cliente) {
		System.out.println("Atualizacao de Cliente = " + cliente);
		Response.ResponseBuilder builder = null;
		try {

			clienteDAO.update(cliente);

			builder = Response.ok().entity(cliente);
			System.out.println("Atualizacao completa de cliente = " + cliente);
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
	public Response deleteCliente(Cliente cliente) {
		System.out.println("Delecao de cliente = " + cliente);
		Response.ResponseBuilder builder = null;

		try {
			if (cliente.getId() != null) {
				clienteDAO.remove(cliente);
			} else {
				System.out.println("Não foi encontrado cliente para ser deletado");
			}
			builder = Response.ok().entity(cliente);
			System.out.println("Delecao efetuada com sucesso = " + cliente);
		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());

			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
	}


}
