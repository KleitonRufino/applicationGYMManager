package br.com.service.impl;

import java.sql.Date;
import java.util.List;

import br.com.dao.BillingDAO;
import br.com.model.Billing;
import br.com.service.IManagerBilling;

public class ManagerBilling implements IManagerBilling {

	private BillingDAO dao;

	public ManagerBilling() {
		this.dao = new BillingDAO();
	}

	@Override
	public void save(Billing billing) {
		this.dao.save(billing);
	}

	@Override
	public List<Billing> findMonth(Date inicio, Date fim) {
		return this.dao.findMonth(inicio, fim);
	}

	@Override
	public List<Billing> findAll() {
		return this.dao.findAll();
	}

	@Override
	public void update(Billing billing) {
		this.dao.update(billing);
	}

	@Override
	public void remove(Long id) {
		this.dao.remove(id);
	}

}
