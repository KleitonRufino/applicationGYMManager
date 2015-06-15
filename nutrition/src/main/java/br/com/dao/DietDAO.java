package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Diet;
import conexao.Conexao;

public class DietDAO {

	public void save(Diet diet, Long idClient) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into dieta(descricao, diadasemana, cliente_id) values (?,?,?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setString(1, diet.getDescription());
			insere.setDate(2, diet.getDiadasemana());
			insere.setLong(3, idClient);
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

	public Diet findDietActual(Long idClient) {
		Diet diet = new Diet();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from dieta c where idCliente=? order by diadasemana desc LIMIT 1";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idClient);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				diet.setId(rs.getLong("id"));
				diet.setDescription(rs.getString("descricao"));
				diet.setDiadasemana(rs.getDate("diadasemana"));
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

		return diet;
	}

	public List<Diet> historyDiet(Long idClient) {
		Diet diet;
		List<Diet> diets = new ArrayList<Diet>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from dieta c where cliente_id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idClient);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				diet = new Diet();
				diet.setId(rs.getLong("id"));
				diet.setDescription(rs.getString("descricao"));
				diet.setDiadasemana(rs.getDate("diadasemana"));
				diets.add(diet);
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
		return diets;
	}

	public void update(Diet diet) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update dieta set descricao=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, diet.getDescription());
			update.setLong(2, diet.getId());
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

	public void delete(Long idDiet) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from dieta where id=?";
		try {
			delete = (PreparedStatement) conexao.prepareStatement(sql);
			delete.setLong(1, idDiet);
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
