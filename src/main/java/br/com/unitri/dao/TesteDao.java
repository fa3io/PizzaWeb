package br.com.unitri.dao;

import java.util.List;

import br.com.unitri.entity.Cliente;

public class TesteDao {

	public static void main(String[] args) {
		
		ClienteDAO dao = new ClienteDAOImpl();
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Flavio Santos Alves");
		cliente.setEndereco("Rua Chipre 164");
		cliente.setUsuario("flavio");
		cliente.setSenha("456");
		
		dao.persist(cliente);
		//dao.update(cliente);
		
		//dao.remove(cliente);
		List<Cliente> clientes =  dao.getAll(Cliente.class);
		
		for (Cliente cli : clientes) {
			System.out.println(cli);
		}

		
	}
}
