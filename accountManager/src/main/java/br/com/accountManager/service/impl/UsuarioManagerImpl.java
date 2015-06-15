package br.com.accountManager.service.impl;

import java.util.List;

import br.com.accountManager.dao.UsuarioDAO;
import br.com.accoutManager.model.Usuario;
import br.com.accoutManager.service.IUsuarioManager;

public class UsuarioManagerImpl implements IUsuarioManager {

	private UsuarioDAO dao;

	public UsuarioManagerImpl() {
		this.dao = new UsuarioDAO();
	}

	@Override
	public void save(Usuario user) {
		this.dao.save(user);
	}

	@Override
	public Usuario find(Long id) {
		return this.dao.find(id);
	}

	@Override
	public Usuario find(String login) {
		return this.dao.find(login);
	}

	@Override
	public Usuario find(String login, String senha) {
		return this.dao.find(login, senha);
	}

	@Override
	public void update(Usuario user) {
		this.dao.update(user);
	}

	@Override
	public void remove(Long id) {
		this.dao.remove(id);
	}

	@Override
	public List<Usuario> findAll() {
		return this.dao.findAll();
	}

}
