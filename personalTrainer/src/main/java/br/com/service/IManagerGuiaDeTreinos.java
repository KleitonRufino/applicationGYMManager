package br.com.service;

import java.util.List;

import br.com.enume.DiaDaSemana;
import br.com.model.GuiaDeTreino;

public interface IManagerGuiaDeTreinos {
	
	public void save(GuiaDeTreino message);
	public GuiaDeTreino findTreinoDoDia(Long clienteId, DiaDaSemana dia);
	public List<GuiaDeTreino> findTreinos(Long clienteId);
	public List<GuiaDeTreino> findAll();
	public void delete(Long id_guia_treinos);
	public void update(GuiaDeTreino novoGuia);
	
}
