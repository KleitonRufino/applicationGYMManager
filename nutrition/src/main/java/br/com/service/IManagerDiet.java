package br.com.service;

import java.util.List;

import br.com.model.Diet;

public interface IManagerDiet {
	
	public void save(Diet diet, Long idClient);
	
	public Diet findDietActual(Long idClient);
	
	public List<Diet> historyDiet(Long idClient);
	
	public void update(Diet diet);
	
	public void delete(Long idDiet);
	
}
