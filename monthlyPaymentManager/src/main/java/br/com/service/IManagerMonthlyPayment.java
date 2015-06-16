package br.com.service;

import java.util.List;

import br.com.enume.Mes;
import br.com.model.Client;

public interface IManagerMonthlyPayment {
	
	public List<Client> listarClientesNaoPagos(Mes mes, int ano);
	public List<Client> listarClientesPagos(Mes mes, int ano);
	public void pagar(int cliente_id, Mes mes, int ano);
}
