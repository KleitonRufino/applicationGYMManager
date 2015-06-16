package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.enume.DiaDaSemana;
import br.com.model.GuiaDeTreino;
import conexao.Conexao;

public class GuiaDetreinoDAO {

	public void save(GuiaDeTreino guia, Long idCliente) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;

		String sql = "insert into guiadetreino(diadasemana, nome,cliente_id, descricaotreino) values (?,?,?,?)";

		// String sql2 =
		// "insert into guidadetreino_treinos(guiadetreino_id,treinos) values (?,?)";

		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setString(1, guia.getDiaDaSemana().toString());
			insere.setString(2, guia.getNome());
			insere.setLong(3, idCliente);
			insere.setString(4, guia.getDescricaoTreino());
			insere.executeUpdate();

			// int id_guia = buscaGuia(guia);
			// PreparedStatement insereTreinos = null;
			// for (String treino : guia.getTreinos()) {
			// insereTreinos = (PreparedStatement)
			// conexao.prepareStatement(sql2);
			// insereTreinos.setInt(1, id_guia);
			// insereTreinos.setString(2, treino);
			// insereTreinos.executeUpdate();
			// }

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

	public GuiaDeTreino findTreinoDoDia(Long clienteId, DiaDaSemana dia) {
		GuiaDeTreino guia_encontrado = new GuiaDeTreino();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from guiadetreino g where cliente_id=? and diadasemana = ?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, clienteId);
			find.setString(2, dia.toString());
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				guia_encontrado.setDiaDaSemana(dia);
				guia_encontrado.setId((long) rs.getInt("id"));
				guia_encontrado.setNome(rs.getString("nome"));
				guia_encontrado.setDescricaoTreino(rs
						.getString("descricaotreino"));
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
		return guia_encontrado;
	}

	public List<GuiaDeTreino> findTreinos(Long clienteId) {
		List<GuiaDeTreino> treinos = new ArrayList<GuiaDeTreino>();
		GuiaDeTreino guia_encontrado;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from guiadetreino g where cliente_id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, clienteId);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				guia_encontrado = new GuiaDeTreino();
				guia_encontrado.setDiaDaSemana(stringParaEnum(rs
						.getString("diadasemana")));
				guia_encontrado.setId((long) rs.getInt("id"));
				guia_encontrado.setNome(rs.getString("nome"));
				guia_encontrado.setDescricaoTreino(rs
						.getString("descricaotreino"));
				treinos.add(guia_encontrado);
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
		return treinos;
	}

	public List<GuiaDeTreino> findAll() {
		List<GuiaDeTreino> treinos = new ArrayList<GuiaDeTreino>();
		GuiaDeTreino guia_encontrado;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from guiadetreino g";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				guia_encontrado = new GuiaDeTreino();
				guia_encontrado.setDiaDaSemana(stringParaEnum(rs
						.getString("diadasemana")));
				guia_encontrado.setId((long) rs.getInt("id"));
				guia_encontrado.setNome(rs.getString("nome"));
				guia_encontrado.setDescricaoTreino(rs
						.getString("descricaoTreino"));
				treinos.add(guia_encontrado);
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
		return treinos;
	}

	public void delete(Long id_guia_treinos) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from guiadetreino where id=?";
		// String sql2 = "delete from guiadetreino where id=?";
		try {
			delete = (PreparedStatement) conexao.prepareStatement(sql);
			delete.setLong(1, id_guia_treinos);
			delete.executeUpdate();

			// PreparedStatement delete_guias = null;
			// delete_guias = (PreparedStatement)
			// conexao.prepareStatement(sql2);
			// delete_guias.setLong(1, id_guia_treinos);
			// delete_guias.executeUpdate();

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

	public void update(GuiaDeTreino novoGuia) {
		// buscar todos os treinos do cliente, deletar e salvar todos dnv
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update guiadetreinos set  nome=?, diaDaSemana=?, descricaotreino=? where id=?";

		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, novoGuia.getNome());
			update.setString(2, novoGuia.getDiaDaSemana().toString());
			update.setString(3, novoGuia.getDescricaoTreino());
			update.setInt(4, novoGuia.getId().intValue());
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

//	private void atualizarTreinos(GuiaDeTreino novoGuia) {
//		Connection conexao = Conexao.getConnection();
//		PreparedStatement delete = null;
//		PreparedStatement insert = null;
//		String sql = "delete from guiadetreino_treinos where guiadetreino_id=?";
//		String sqlInsert = "insert into guidadetreino_treinos(guiadetreino_id,treinos) values (?,?)";
//		/try {
//			delete = (PreparedStatement) conexao.prepareStatement(sql);
//			delete.setLong(1, novoGuia.getId());
//			delete.executeUpdate();
//
//			insert = (PreparedStatement) conexao.prepareStatement(sqlInsert);
//			for (String treino : novoGuia.getTreinos()) {
//				insert.setInt(1, novoGuia.getId().intValue());
//				insert.setString(2, treino);
//			}
//			insert.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				delete.close();
//				conexao.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	private List<String> findTreinosDoGuia(Long guia_id) {
//		List<String> treinos = new ArrayList<String>();
//		Connection conexao = Conexao.getConnection();
//		PreparedStatement find = null;
//		String sql = "select * from guiadetreino_treinos g where g.guiadetreino_id=?";
//		try {
//			find = (PreparedStatement) conexao.prepareStatement(sql);
//			find.setInt(1, guia_id.intValue());
//			ResultSet rs = find.executeQuery();
//			while (rs.next()) {
//				treinos.add(rs.getString("treinos"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				find.close();
//				conexao.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return treinos;
//	}

	private DiaDaSemana stringParaEnum(String string) {
		if (string.equals("SEGUNDA")) {
			return DiaDaSemana.SEGUNDA;
		}
		if (string.equals("TERCA")) {
			return DiaDaSemana.TERCA;
		}
		if (string.equals("QUARTA")) {
			return DiaDaSemana.QUARTA;
		}
		if (string.equals("QUINTA")) {
			return DiaDaSemana.QUINTA;
		}
		if (string.equals("SEXTA")) {
			return DiaDaSemana.SEXTA;
		}
		if (string.equals("SABADO")) {
			return DiaDaSemana.SABADO;
		}
		if (string.equals("DOMINGO")) {
			return DiaDaSemana.DOMINGO;
		}
		return null;
	}

//	private int buscaGuia(GuiaDeTreino guia, Long idCliente) {
//		int guia_encontrado = -1;
//		Connection conexao = Conexao.getConnection();
//		PreparedStatement find = null;
//		String sql = "select * from guiadetreino g where (nome = ? and diadasemana = ?)";
//		try {
//			find = (PreparedStatement) conexao.prepareStatement(sql);
//			find.setString(1, guia.g);(1, );
//			ResultSet rs = find.executeQuery();
//			while (rs.next()) {
//				guia_encontrado = rs.getInt("id");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				find.close();
//				conexao.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return guia_encontrado;
//	}
}
