package br.com.service.impl;

import java.util.List;

import br.com.dao.DietDAO;
import br.com.model.Diet;
import br.com.service.IManagerDiet;

public class ManagerDietImpl implements IManagerDiet {

	private DietDAO dao;

	public ManagerDietImpl() {
		this.dao = new DietDAO();
	}

	@Override
	public void save(Diet diet, Long idClient) {
		this.dao.save(diet, idClient);
	}

	@Override
	public Diet findDietActual(Long idClient) {
		return this.findDietActual(idClient);
	}

	@Override
	public List<Diet> historyDiet(Long idClient) {
		return this.dao.historyDiet(idClient);
	}

	@Override
	public void update(Diet diet) {
		this.dao.update(diet);
	}

	@Override
	public void delete(Long idDiet) {
		this.dao.delete(idDiet);
	}

}
