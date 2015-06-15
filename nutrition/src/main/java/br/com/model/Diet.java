package br.com.model;

import java.sql.Date;

public class Diet {
	private Long id;
	private String description;
	private Date diadasemana;

	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDiadasemana() {
		return diadasemana;
	}

	public void setDiadasemana(Date diadasemana) {
		this.diadasemana = diadasemana;
	}

}
