package br.com.unitri.pizzaweb.dao;

import br.com.unitri.pizzaweb.entity.Cliente;

public interface ClienteDAO extends DAO<Cliente, Integer> {
	
	
	Cliente getByLogin(String usuario, String senha);
	
	
}
