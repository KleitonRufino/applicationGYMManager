package br.com.service.impl;

import java.util.List;

import br.com.dao.BodyConditionDAO;
import br.com.model.BodyCondition;
import br.com.service.IManagerBodyCondition;

public class ManagerBodyConditionImpl implements IManagerBodyCondition {
	private BodyConditionDAO dao;
	public ManagerBodyConditionImpl() {
		this.dao = new BodyConditionDAO();
	}
	
	
	@Override
	public List<BodyCondition> findByUser(Long idClient) {
		return this.dao.findByUser(idClient);
	}

	@Override
	public BodyCondition currentBodyCondition(Long idClient) {
		return this.dao.currentBodyCondition(idClient);
	}

	@Override
	public void addBodyCondition(BodyCondition condition, Long idClient) {
		this.dao.addBodyCondition(condition, idClient);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

}
