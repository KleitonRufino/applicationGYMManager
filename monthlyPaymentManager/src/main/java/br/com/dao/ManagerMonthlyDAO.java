package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.model.Client;
import conexao.Conexao;

public class ManagerMonthlyDAO {
	@SuppressWarnings("deprecation")
	public void verificarMensalidade() {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update cliente set ativo=FALSE where datavencimento < ?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setLong(1, new Date(System.currentTimeMillis()).getDay());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				update.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Client> listarClientesNaoPagos() {
		Client devedor;
		List<Client> clientesDevedores = new ArrayList<Client>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from cliente c where c.ativo = FALSE";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				devedor = new Client();
				devedor.setId(rs.getLong("id"));
				devedor.setAtivo(rs.getBoolean("ativo"));
				devedor.setCpf(rs.getLong("cpf"));
				devedor.setDataNascimento(rs.getDate("datanascimento"));
				devedor.setDataVencimento(rs.getInt("datavencimento"));
				devedor.setNome(rs.getString("nome"));
				clientesDevedores.add(devedor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				find.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clientesDevedores;
	}
}
