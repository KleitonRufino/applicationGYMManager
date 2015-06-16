package br.com.model;

import br.com.enume.DiaDaSemana;

public class GuiaDeTreino {

	private Long id;
	private DiaDaSemana diaDaSemana;
	private String nome;
	private String descricaoTreino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescricaoTreino() {
		return descricaoTreino;
	}

	public void setDescricaoTreino(String descricaoTreino) {
		this.descricaoTreino = descricaoTreino;
	}

}
