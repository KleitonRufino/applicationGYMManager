package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Colaborator;
import conexao.Conexao;

public class ColaboratorDAO {

	public Colaborator findById(Long idColaborator) {
		Colaborator colaborator = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * colaborador where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idColaborator);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				colaborator = new Colaborator();
				colaborator.setId(rs.getLong(1));
				colaborator.setNome(rs.getString(2));
				colaborator.setCargo(rs.getString(3));
				colaborator.setSalario(rs.getDouble(4));
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
		return colaborator;
	}

	public List<Colaborator> findAll() {
		Colaborator colaborator;
		List<Colaborator> colaborators = new ArrayList<Colaborator>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from colaborador";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				colaborator = new Colaborator();
				colaborator.setId(rs.getLong("id"));
				colaborator.setNome(rs.getString("nome"));
				colaborator.setCargo(rs.getString("cargo"));
				colaborator.setSalario(rs.getDouble("salario"));
				colaborators.add(colaborator);
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
		return colaborators;
	}

	public Colaborator findByName(String nomeColaborator) {
		Colaborator colaborator = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from colaborador where nome=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setString(1, nomeColaborator);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				colaborator = new Colaborator();
				colaborator.setId(rs.getLong(1));
				colaborator.setNome(rs.getString(2));
				colaborator.setCargo(rs.getString(3));
				colaborator.setSalario(rs.getDouble(4));
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
		return colaborator;
	}

	public void addColaborator(Colaborator colaborator) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into colaborador(cargo, nome, salario) values (?, ?, ?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setString(1, colaborator.getCargo());
			insere.setString(2, colaborator.getNome());
			insere.setDouble(3, colaborator.getSalario());
			insere.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				insere.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateColaborator(Colaborator colaborator) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update colaborador set cargo=?, nome=?, salario=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, colaborator.getCargo());
			update.setString(2, colaborator.getNome());
			update.setDouble(3, colaborator.getSalario());
			update.setLong(4, colaborator.getId());
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

	public void deleteColaborator(Long idColaborator) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from colaborador where id=?";
		try {
			delete = (PreparedStatement) conexao.prepareStatement(sql);
			delete.setLong(1, idColaborator);
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
