package br.com.unitri.pizzaweb.interfaces;

import javax.ejb.Remote;

import br.com.unitri.pizzaweb.entity.Cliente;

@Remote
public interface ClienteSessionBeanRemote {

	 void salvar(Cliente cliente);
	
	 void atualizar(Cliente cliente);
	
	 void deletar(Cliente cliente);
	 
	 Cliente buscarPorId(Integer id);
	
	
	
}
