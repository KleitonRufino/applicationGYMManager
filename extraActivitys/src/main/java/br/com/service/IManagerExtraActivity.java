package br.com.service;

import java.util.List;

import br.com.model.ExtraActivity;

public interface IManagerExtraActivity {

	public List<ExtraActivity> findByExtraActivityByUser(Long idClient);

	public void addExtraActivity(ExtraActivity condition, Long idClient);

	public void updateExtraActivity(ExtraActivity extraActivity, Long idClient);

	public void deleteExtraActivity(Long id);

}
