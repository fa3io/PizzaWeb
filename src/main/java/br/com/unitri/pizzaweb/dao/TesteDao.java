package br.com.unitri.pizzaweb.dao;

import java.util.List;

import br.com.unitri.pizzaweb.entity.Cliente;

public class TesteDao {

	public static void main(String[] args) {
		
		ClienteDAO dao = new ClienteDAOImpl();
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Fábio Santos Alves");
		cliente.setEndereco("Rua Chipre 164");
		cliente.setUsuario("fabio");
		cliente.setSenha("254690");
		
		dao.persist(cliente);
		//dao.update(cliente);
		
		//dao.remove(cliente);
		List<Cliente> clientes =  dao.getAll(Cliente.class);
		
		for (Cliente cli : clientes) {
			System.out.println(cli);
		}

		
	}
}
