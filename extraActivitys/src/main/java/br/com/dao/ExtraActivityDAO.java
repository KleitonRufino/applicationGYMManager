package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.ExtraActivity;
import conexao.Conexao;

public class ExtraActivityDAO {

	public List<ExtraActivity> findByExtraActivityByUser(Long idClient) {
		ExtraActivity extraActivity;
		List<ExtraActivity> extraActivitys = new ArrayList<ExtraActivity>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from atividadeextra a where cliente_id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idClient);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				extraActivity = new ExtraActivity();
				extraActivity.setId(rs.getLong("id"));
				extraActivity.setNomeAtividade(rs.getString("nome"));
				extraActivity.setNomeAtividade(rs.getString("duracao"));
				extraActivity.setDiaAtividade(rs.getDate("diaatividade"));
				extraActivity.setDiaAtividade(rs.getDate("horaatividade"));
				extraActivitys.add(extraActivity);
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
		return extraActivitys;
	}

	public void addExtraActivity(ExtraActivity extraActivity, Long idClient) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into atividadeextra(nome, duracao, diaatividade, horaatividade, cliente_id) values (?, ?, ?, ?, ?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setString(1, extraActivity.getNomeAtividade());
			insere.setString(2, extraActivity.getDuracaoAtividade());
			insere.setDate(3, extraActivity.getDiaAtividade());
			insere.setDate(4, extraActivity.getHoraAtividade());
			insere.setLong(5, idClient);
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

	public void updateExtraActivity(ExtraActivity extraActivity) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update atividadeextra set nome=?, duracao=?, diaatividade=?, horaatividade=?, cliente_id=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, extraActivity.getNomeAtividade());
			update.setString(2, extraActivity.getDuracaoAtividade());
			update.setDate(3, extraActivity.getDiaAtividade());
			update.setDate(4, extraActivity.getHoraAtividade());
			update.setLong(5, extraActivity.getIdCliente());
			update.setLong(6, extraActivity.getId());
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

	public void deleteExtraActivity(Long id) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from extraactivity where id=?";
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
