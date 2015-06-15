package br.com.service.impl;

import java.util.List;

import br.com.dao.GuiaDetreinoDAO;
import br.com.enume.DiaDaSemana;
import br.com.model.GuiaDeTreino;
import br.com.service.IManagerGuiaDeTreinos;

public class ManagerGuiaDeTreinosImpl implements IManagerGuiaDeTreinos {
	GuiaDetreinoDAO dao = new GuiaDetreinoDAO();
	
	@Override
	public void save(GuiaDeTreino guia) {
		dao.save(guia);
	}


	@Override
	public GuiaDeTreino findTreinoDoDia(Long clienteId, DiaDaSemana dia) {
		return dao.findTreinoDoDia(clienteId, dia);
	}

	@Override
	public List<GuiaDeTreino> findTreinos(Long clienteId) {
		return dao.findTreinos(clienteId);
	}

	@Override
	public List<GuiaDeTreino> findAll() {
		return dao.findAll();
	}

	@Override
	public void delete(Long id_guia_treinos) {
		dao.delete(id_guia_treinos);
	}

	@Override
	public void update(GuiaDeTreino novoGuia) {
		dao.update(novoGuia);
	}
}
