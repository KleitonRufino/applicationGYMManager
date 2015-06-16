package br.com.service.impl;

import java.util.List;

import br.com.dao.ManagerMonthlyDAO;
import br.com.model.Client;
import br.com.service.IManagerMonthlyPayment;

public class MonthlyPaymentManager implements IManagerMonthlyPayment {

	private ManagerMonthlyDAO dao;
	public MonthlyPaymentManager() {
		this.dao = new ManagerMonthlyDAO();
	}
	
	// @Override
	// public List<Client> listarClientesNaoPagos(Mes mes, int ano) {
	// Client devedor;
	// List<Client> clientesDevedores = new ArrayList<Client>();
	// Connection conexao = Conexao.getConnection();
	// PreparedStatement find = null;
	// String sql =
	// "select * from cliente c where c.ativo = TRUE and c.id NOT IN (select cliente_id from mensalidades a where mesreferencia=? and ano = ?)";
	// try {
	// find = (PreparedStatement) conexao.prepareStatement(sql);
	// find.setString(1, mes.toString());
	// find.setInt(2, ano);
	// ResultSet rs = find.executeQuery();
	// while (rs.next()) {
	// devedor = new Client();
	// devedor.setId(rs.getLong("id"));
	// devedor.setAtivo(rs.getBoolean("ativo"));
	// devedor.setCpf(rs.getLong("cpf"));
	// devedor.setDataNascimento(rs.getDate("datanascimento"));
	// devedor.setDataVencimento(rs.getInt("datavencimento"));
	// devedor.setNome(rs.getString("nome"));
	// clientesDevedores.add(devedor);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// find.close();
	// conexao.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// return clientesDevedores;
	// }
	//
	// @Override
	// public List<Client> listarClientesPagos(Mes mes, int ano) {
	// Client clienteEmDia;
	// List<Client> clientesEmDia = new ArrayList<Client>();
	// Connection conexao = Conexao.getConnection();
	// PreparedStatement find = null;
	// String sql =
	// "select * from cliente c where c.id IN (select cliente_id from mensalidades a where mesreferencia=? and ano = ?)";
	// try {
	// find = (PreparedStatement) conexao.prepareStatement(sql);
	// find.setString(1, mes.toString());
	// find.setInt(2, ano);
	// ResultSet rs = find.executeQuery();
	// while (rs.next()) {
	// clienteEmDia = new Client();
	// clienteEmDia.setId(rs.getLong("id"));
	// clienteEmDia.setAtivo(rs.getBoolean("ativo"));
	// clienteEmDia.setCpf(rs.getLong("cpf"));
	// clienteEmDia.setDataNascimento(rs.getDate("datanascimento"));
	// clienteEmDia.setDataVencimento(rs.getInt("datavencimento"));
	// clienteEmDia.setNome(rs.getString("nome"));
	// clientesEmDia.add(clienteEmDia);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// find.close();
	// conexao.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// return clientesEmDia;
	// }
	//
	// @Override
	// public void pagar(int cliente_id, Mes mes, int ano) {
	// Connection conexao = Conexao.getConnection();
	// PreparedStatement insere = null;
	// String sql =
	// "insert into mensalidades(mesreferencia, ano, cliente_id) values (?, ?, ?)";
	// try {
	// insere = (PreparedStatement) conexao.prepareStatement(sql);
	// insere.setString(1, mes.toString());
	// insere.setInt(2, ano);
	// insere.setLong(3, cliente_id);
	// insere.executeUpdate();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// insere.close();
	// conexao.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	@Override
	public void verificarMensalidade() {
		this.dao.verificarMensalidade();
	}

	@Override
	public List<Client> listarClientesNaoPagos() {
		return this.dao.listarClientesNaoPagos();
	}

}
