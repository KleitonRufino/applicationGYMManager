package br.com.service.impl;

import java.util.List;

import br.com.dao.ExtraActivityDAO;
import br.com.model.ExtraActivity;
import br.com.service.IManagerExtraActivity;

public class ManagerExtraActivityImpl implements IManagerExtraActivity {
	private ExtraActivityDAO dao;

	public ManagerExtraActivityImpl() {
		this.dao = new ExtraActivityDAO();
	}

	@Override
	public List<ExtraActivity> findByExtraActivityByUser(Long idClient) {
		return this.dao.findByExtraActivityByUser(idClient);
	}

	@Override
	public void addExtraActivity(ExtraActivity condition, Long idClient) {
		this.dao.addExtraActivity(condition, idClient);
	}

	@Override
	public void deleteExtraActivity(Long id) {
		this.dao.deleteExtraActivity(id);
	}

	@Override
	public void updateExtraActivity(ExtraActivity extraActivity, Long idClient) {
		this.dao.updateExtraActivity(extraActivity);
	}

}
