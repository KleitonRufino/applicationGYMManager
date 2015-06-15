package br.com.model;

import java.sql.Date;

public class BodyCondition {
	private Long id;
	private Double altura;
	private Double antebraco;
	private Double biceps;
	private Double cintura;
	private Double coxa;
	private Date datadacondicao;
	private Double gluteo;
	private Double mtorax;
	private Double panturilha;
	private Double peso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getAntebraco() {
		return antebraco;
	}

	public void setAntebraco(Double antebraco) {
		this.antebraco = antebraco;
	}

	public Double getBiceps() {
		return biceps;
	}

	public void setBiceps(Double biceps) {
		this.biceps = biceps;
	}

	public Double getCintura() {
		return cintura;
	}

	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}

	public Double getCoxa() {
		return coxa;
	}

	public void setCoxa(Double coxa) {
		this.coxa = coxa;
	}

	public Date getDatadacondicao() {
		return datadacondicao;
	}

	public void setDatadacondicao(Date datadacondicao) {
		this.datadacondicao = datadacondicao;
	}

	public Double getGluteo() {
		return gluteo;
	}

	public void setGluteo(Double gluteo) {
		this.gluteo = gluteo;
	}

	public Double getMtorax() {
		return mtorax;
	}

	public void setMtorax(Double mtorax) {
		this.mtorax = mtorax;
	}

	public Double getPanturilha() {
		return panturilha;
	}

	public void setPanturilha(Double panturilha) {
		this.panturilha = panturilha;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
