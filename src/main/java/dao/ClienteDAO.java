package dao;

import java.util.List;

import entidade.Cliente;
import entidade.Contato;

public interface ClienteDAO {
	
	public boolean inserirCliente(Cliente cliente);
	
	public List<Cliente> pesquisarCliente(Cliente cliente, Contato contato);
	
	public boolean adicionarContatoCliente(Cliente cliente);
	
	public boolean removerContatoCliente(Cliente cliente);
	
	public Cliente existeCliente(Cliente cliente);

	public boolean removerContatoCliente(Contato contato);

	public boolean removerCliente(Cliente cliente);

}
