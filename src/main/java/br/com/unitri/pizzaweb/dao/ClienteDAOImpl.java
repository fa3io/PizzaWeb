package br.com.unitri.pizzaweb.dao;

import javax.persistence.TypedQuery;

import br.com.unitri.pizzaweb.entity.Cliente;

public class ClienteDAOImpl extends AbstractDAO<Cliente, Integer> implements ClienteDAO {

	@Override
	public Cliente getByLogin(String usuario, String senha) {
		Cliente cliente = null;
		String query = "Select c from Cliente c where c.usuario = :usuario AND c.senha = :senha";
		try {
			TypedQuery<Cliente> tq = manager.createQuery(query, Cliente.class);
			cliente = tq.setParameter("usuario", usuario).setParameter("senha", senha).getSingleResult();
		} catch (Exception e) {
		
		}		
		return cliente;
	}}
