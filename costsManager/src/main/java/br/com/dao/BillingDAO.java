package br.com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import br.com.model.Billing;

public class BillingDAO {
	public void save(Billing billing) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insereSt = null;
		String sql = "insert into conta(datavencimento, descricao, statuspagamento, tipoconta, valorconta) values (?,?,?,?,?)";
		try {
			insereSt = (PreparedStatement) conexao.prepareStatement(sql);
			insereSt.setDate(1, billing.getDatavencimento());
			insereSt.setString(2, billing.getDescricao());
			insereSt.setBoolean(3, billing.isStatuspagamento());
			insereSt.setString(4, billing.getTipoConta());
			insereSt.setDouble(5, billing.getValorconta());
			insereSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				insereSt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Billing> findMonth(Date inicio, Date fim) {
		Billing billing;
		List<Billing> billings = new ArrayList<Billing>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from conta where (datavencimento >=? and datavencimento <=?)";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setDate(1, inicio);
			find.setDate(2, fim);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				billing = new Billing();
				billing.setId(rs.getLong("id"));
				billing.setStatuspagamento(rs.getBoolean("statuspagamento"));
				billing.setDescricao(rs.getString("descricao"));
				billing.setDatavencimento(rs.getDate("datavencimento"));
				billing.setTipoConta(rs.getString("tipoconta"));
				billing.setValorconta(rs.getDouble("valorconta"));
				billings.add(billing);
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
		return billings;
	}

	public List<Billing> findAll() {
		Billing billing;
		List<Billing> billings = new ArrayList<Billing>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from conta";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				billing = new Billing();
				billing.setId(rs.getLong("id"));
				billing.setStatuspagamento(rs.getBoolean("statuspagamento"));
				billing.setDescricao(rs.getString("descricao"));
				billing.setDatavencimento(rs.getDate("datavencimento"));
				billing.setTipoConta(rs.getString("tipoconta"));
				billing.setValorconta(rs.getDouble("valorconta"));
				billings.add(billing);
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
		return billings;
	}

	public void update(Billing billing) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update conta set datavencimento=?, descricao=?, statuspagamento=?, tipoconta=?, valorconta=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setDate(1, billing.getDatavencimento());
			update.setString(2, billing.getDescricao());
			update.setBoolean(3, billing.isStatuspagamento());
			update.setDouble(4, billing.getValorconta());
			update.setString(5, billing.getTipoConta());
			update.setLong(6, billing.getId());
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

	public void remove(Long id) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from conta where id=?";
		try {
			delete = (PreparedStatement) conexao.prepareStatement(sql);
			delete.setLong(1, id);
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				delete.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
