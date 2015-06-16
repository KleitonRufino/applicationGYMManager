package br.com.model;

import java.sql.Date;

public class ExtraActivity {
	private Long id;
	private Long idCliente;
	private String nomeAtividade;
	private String duracaoAtividade;
	private Date diaAtividade;
	private Date horaAtividade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public String getDuracaoAtividade() {
		return duracaoAtividade;
	}

	public void setDuracaoAtividade(String duracaoAtividade) {
		this.duracaoAtividade = duracaoAtividade;
	}

	public Date getDiaAtividade() {
		return diaAtividade;
	}

	public void setDiaAtividade(Date diaAtividade) {
		this.diaAtividade = diaAtividade;
	}

	public Date getHoraAtividade() {
		return horaAtividade;
	}

	public void setHoraAtividade(Date horaAtividade) {
		this.horaAtividade = horaAtividade;
	}

}
