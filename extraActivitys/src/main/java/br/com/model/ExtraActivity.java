package br.com.model;

import java.sql.Date;

public class ExtraActivity {
	private Long id;
	private String nome;
	private String duracao;
	private Date diaatividade;
	private String horaatividade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Date getDiaatividade() {
		return diaatividade;
	}

	public void setDiaatividade(Date diaatividade) {
		this.diaatividade = diaatividade;
	}

	public String getHoraatividade() {
		return horaatividade;
	}

	public void setHoraatividade(String horaatividade) {
		this.horaatividade = horaatividade;
	}


}
