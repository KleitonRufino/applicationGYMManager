package br.com.model;

import java.sql.Date;

public class Client {
	private Long id;
	private boolean ativo;
	private Long cpf;
	private Date dataNascimento;
	private int dataVencimento;
	private String nome;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public int getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(int dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setId(long id) {
		this.id = id;
	}

}
