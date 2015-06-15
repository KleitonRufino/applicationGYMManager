package br.com.accoutManager.service;

import java.util.List;

import br.com.accoutManager.model.Usuario;

public interface IUsuarioManager {

	public void save(Usuario user);

	public Usuario find(Long id);

	public Usuario find(String login);

	public Usuario find(String login, String senha);

	public void update(Usuario user);

	public void remove(Long id);
	
	public List<Usuario> findAll();
}
