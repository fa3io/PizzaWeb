package br.com.unitri.pizzaweb.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.unitri.pizzaweb.dao.ClienteDAO;
import br.com.unitri.pizzaweb.entity.Cliente;
import br.com.unitri.pizzaweb.interfaces.ClienteSessionBeanRemote;

@Stateless
public class ClienteSessionBean implements ClienteSessionBeanRemote{

	@Inject
	ClienteDAO clienteDAO;
	
	@Override
	public void salvar(Cliente cliente) {
		clienteDAO.persist(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		clienteDAO.update(cliente);
	}

	@Override
	public void deletar(Cliente cliente) {
	clienteDAO.remove(cliente);
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		return clienteDAO.getById(Cliente.class, id);
		
	}

}
