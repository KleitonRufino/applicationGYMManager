package br.com.model;

import java.sql.Date;

public class Billing {
	private Long id;
	private Date datavencimento;
	private String descricao;
	private boolean statuspagamento;
	private String tipoConta;
	private Double valorconta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatuspagamento() {
		return statuspagamento;
	}

	public void setStatuspagamento(boolean statuspagamento) {
		this.statuspagamento = statuspagamento;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Double getValorconta() {
		return valorconta;
	}

	public void setValorconta(Double valorconta) {
		this.valorconta = valorconta;
	}

}
