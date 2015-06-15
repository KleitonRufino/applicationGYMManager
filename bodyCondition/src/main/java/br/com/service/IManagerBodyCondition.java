package br.com.service;

import java.util.List;

import br.com.model.BodyCondition;

public interface IManagerBodyCondition {
	
	
	public List<BodyCondition> findByUser(Long idClient);

	public BodyCondition currentBodyCondition(Long idClient);
	
	public void addBodyCondition(BodyCondition condition, Long idClient);
	
	public void delete(Long id);
	
}
