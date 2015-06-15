package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.BodyCondition;
import conexao.Conexao;

public class BodyConditionDAO {

	public List<BodyCondition> findByUser(Long idClient) {
		BodyCondition condition;
		List<BodyCondition> conditions = new ArrayList<BodyCondition>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from condicaofisica c where cliente_id=? order by datadacondicao desc";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idClient);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				condition = new BodyCondition();
				condition.setId(rs.getLong("id"));
				condition.setAltura(rs.getDouble("altura"));
				condition.setAntebraco(rs.getDouble("antebraco"));
				condition.setBiceps(rs.getDouble("biceps"));
				condition.setCintura(rs.getDouble("cintura"));
				condition.setCoxa(rs.getDouble("coxa"));
				condition.setDatadacondicao(rs.getDate("datadacondicao"));
				condition.setGluteo(rs.getDouble("gluteo"));
				condition.setMtorax(rs.getDouble("mtorax"));
				condition.setPeso(rs.getDouble("peso"));
				conditions.add(condition);
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
		return conditions;
	}

	public BodyCondition currentBodyCondition(Long idClient) {
		BodyCondition condition = new BodyCondition();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from condicaofisica c where cliente_id=? order by datadacondicao desc LIMIT 1";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idClient);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				condition.setId(rs.getLong("id"));
				condition.setAltura(rs.getDouble("altura"));
				condition.setAntebraco(rs.getDouble("antebraco"));
				condition.setBiceps(rs.getDouble("biceps"));
				condition.setCintura(rs.getDouble("cintura"));
				condition.setCoxa(rs.getDouble("coxa"));
				condition.setDatadacondicao(rs.getDate("datadacondicao"));
				condition.setGluteo(rs.getDouble("gluteo"));
				condition.setMtorax(rs.getDouble("mtorax"));
				condition.setPeso(rs.getDouble("peso"));
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
		return condition;
	}

	public void addBodyCondition(BodyCondition condition, Long idClient) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into condicaofisica(altura,antebraco,biceps,cintura,coxa,datadacondicao,gluteo, mtorax, panturrilha, peso, cliente_id) values (?,?,?,?,?,?, ?, ?, ?, ?, ?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setDouble(1, condition.getAltura());
			insere.setDouble(2, condition.getAntebraco());
			insere.setDouble(3, condition.getBiceps());
			insere.setDouble(4, condition.getCintura());
			insere.setDouble(5, condition.getCoxa());
			insere.setDate(6, condition.getDatadacondicao());
			insere.setDouble(7, condition.getGluteo());
			insere.setDouble(8, condition.getMtorax());
			insere.setDouble(9, condition.getPanturilha());
			insere.setDouble(10, condition.getPeso());
			insere.setLong(11, idClient);
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

	public void delete(Long id) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from condicaofisica where id=?";
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
