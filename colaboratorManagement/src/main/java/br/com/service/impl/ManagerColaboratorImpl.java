package br.com.service.impl;

import java.util.List;

import br.com.dao.ColaboratorDAO;
import br.com.model.Colaborator;
import br.com.service.IManagerColaborator;

public class ManagerColaboratorImpl implements IManagerColaborator {
	private ColaboratorDAO dao;

	public ManagerColaboratorImpl() {
		this.dao = new ColaboratorDAO();
	}

	@Override
	public Colaborator findById(Long idColaborator) {
		return this.dao.findById(idColaborator);
	}

	@Override
	public Colaborator findByName(String nomeColaborator) {
		return this.dao.findByName(nomeColaborator);
	}

	public void addColaborator(Colaborator colaborator) {
		this.dao.addColaborator(colaborator);
	}

	@Override
	public void updateColaborator(Colaborator colaborator) {
		this.dao.updateColaborator(colaborator);
	}

	@Override
	public void deleteColaborator(Long idColaborator) {
		this.dao.deleteColaborator(idColaborator);
	}

	@Override
	public List<Colaborator> findAll() {
		return this.dao.findAll();
	}


}
