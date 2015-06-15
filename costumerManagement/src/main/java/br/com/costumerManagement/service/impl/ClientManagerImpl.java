package br.com.costumerManagement.service.impl;

import java.util.List;

import br.com.costumerManagement.dao.ClientDAO;
import br.com.costumerManagement.model.Client;
import br.com.costumerManagement.service.IClientManager;

public class ClientManagerImpl implements IClientManager {

	private ClientDAO dao;

	public ClientManagerImpl() {
		this.dao = new ClientDAO();
	}

	@Override
	public void save(Client client, Long idUser) {
		this.dao.save(client, idUser);
	}

	@Override
	public Client find(Long id) {
		return this.dao.find(id);
	}

	@Override
	public List<Client> findAll() {
		return this.dao.findAll();
	}

	@Override
	public List<Client> findName(String nome) {
		return this.dao.findName(nome);
	}

	@Override
	public void update(Client client) {
		this.dao.update(client);
	}

	@Override
	public void remove(Long id) {
		this.dao.remove(id);
	}

	@Override
	public Client findByIdUser(Long idUser) {
		return this.dao.findByIdUser(idUser);
	}

}
