package br.com.service;

import java.sql.Date;
import java.util.List;

import br.com.model.Billing;


public interface IManagerBilling {
	
	public void save(Billing billing);
	
	public List<Billing> findMonth(Date inicio, Date fim);
	
	public List<Billing> findAll();
	
	public void update(Billing billing);
	
	public void remove(Long id);
}
