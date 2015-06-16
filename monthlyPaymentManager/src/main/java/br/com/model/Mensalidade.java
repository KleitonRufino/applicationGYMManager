package br.com.model;

import br.com.enume.Mes;

public class Mensalidade {
	   
    private Long id;
	private Mes mesReferencia;
	private Long cliente_id;
	private int ano;
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAno() {
		return ano;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Mes getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(Mes mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public Long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	
}
