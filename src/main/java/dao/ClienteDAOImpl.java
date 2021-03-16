package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Cliente;
import entidade.Contato;
import util.JpaUtil;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public boolean inserirCliente(Cliente cliente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(cliente);

		tx.commit();
		ent.close();

		return true;
	}

	private String montarWhere(Cliente cliente, Contato contato) {

		String where = "";

		if (cliente.getCpf() != null && !cliente.getCpf().isEmpty()) {
			where += " and cl.cpf = '" + cliente.getCpf() + "'";
		} else {
			if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
				where += " and upper(cl.nome) like '%" + cliente.getNome().toUpperCase() + "%'";
			}

			if (cliente.getSexo() != null && !cliente.getSexo().isEmpty()) {
				where += " and cl.sexo = '" + cliente.getSexo() + "'";
			}

			if (contato.getEmail() != null && !contato.getEmail().isEmpty()) {
				where += " and upper(co.email) like '%" + contato.getEmail().toUpperCase() + "%'";
			}

			if (contato.getTelefone() != null && !contato.getTelefone().isEmpty()) {
				where += " and co.telefone like '%" + contato.getTelefone() + "%'";
			}
		}
		return where;
	}

	@Override
	public List<Cliente> pesquisarCliente(Cliente cliente, Contato contato) {

		String sql = "Select distinct cl from Cliente cl, Contato co " + " where cl.cpf = co.cliente.cpf "
				+ montarWhere(cliente, contato);

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Cliente> listaClientes = query.getResultList();

		ent.close();

		return listaClientes;
	}

	@Override
	public boolean adicionarContatoCliente(Cliente cliente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		for (Contato contato : cliente.getListaContatos()) {
			ent.merge(contato);
		}

		tx.commit();
		ent.close();

		return true;
	}

	@Override
	public boolean removerContatoCliente(Cliente cliente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		for (Contato contato : cliente.getListaContatos()) {
			Contato existe = ent.find(Contato.class, contato.getId());
			if (existe != null) {
				ent.remove(existe);
			}
		}

		tx.commit();
		ent.close();
		return true;

	}

	public Cliente existeCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();

		Cliente existe = ent.find(Cliente.class, cliente.getCpf());

		ent.close();
		return existe;

	}

	@Override
	public boolean removerContatoCliente(Contato contato) {

		EntityManager ent = JpaUtil.getEntityManager();
		Contato existe = ent.find(Contato.class, contato.getId());

		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		
		ent.remove(existe);

		tx.commit();
		ent.close();
		return true;

	}

	@Override
	public boolean removerCliente(Cliente cliente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		
		Cliente existe = ent.find(Cliente.class, cliente.getCpf());

		tx.begin();
		
		ent.remove(existe);

		tx.commit();
		ent.close();
		return true;

	}
}
