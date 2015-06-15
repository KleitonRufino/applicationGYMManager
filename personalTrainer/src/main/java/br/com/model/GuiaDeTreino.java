package br.com.model;

import java.util.List;

import br.com.enume.DiaDaSemana;

public class GuiaDeTreino {
	
	private Long id;
	private Long cliente_id;
	private DiaDaSemana diaDaSemana;
	private String nome;
	private List<String> treinos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getTreinos() {
		return treinos;
	}
	public void setTreinos(List<String> treinos) {
		this.treinos = treinos;
	}
	
	public void addTreinos(String treino){
		this.treinos.add(treino);
	}
	
	
	

}
