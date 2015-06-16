package br.com.service;

import java.util.List;

import br.com.model.Client;

public interface IManagerMonthlyPayment {

	public void verificarMensalidade();

	public List<Client> listarClientesNaoPagos();
}
