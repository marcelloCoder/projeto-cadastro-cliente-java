package br.com.projeto.cadastro.cliente.dao;

import java.util.Collection;

import br.com.projeto.cadastro.cliente.classes.Cliente;

public interface IClienteDAO {
	
	public Boolean cadastrar(Cliente cliente);
	
	public void excluir(Long cpf);
	
	public void alterar(Cliente cliente);
	
	public Cliente consultar(Long cpf);
	
	public Collection<Cliente> buscarTodos();

}
