package br.com.accountManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.accoutManager.model.Usuario;
import conexao.Conexao;

public class UsuarioDAO {

	public void save(Usuario user) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insereSt = null;
		String sql = "insert into usuario(login, senha) values (?,?)";
		try {
			insereSt = (PreparedStatement) conexao.prepareStatement(sql);
			insereSt.setString(1, user.getLogin());
			insereSt.setString(2, user.getSenha());
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

	public Usuario find(Long id) {
		Usuario user = new Usuario();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select id, login, senha from usuario u where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				user.setId(rs.getLong(1));
				user.setLogin(rs.getString(2));
				user.setSenha(rs.getString(3));
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

		return user;
	}

	public Usuario find(String login) {
		Usuario user = new Usuario();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from usuario u where login=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setString(1, login);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				user.setId(rs.getLong(1));
				user.setLogin(rs.getString(2));
				user.setSenha(rs.getString(3));
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

		return user;
	}

	public List<Usuario> findAll() {
		Usuario usuario;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from usuario";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));

				usuarios.add(usuario);
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
		return usuarios;
	}

	public Usuario find(String login, String senha) {
		Usuario user = new Usuario();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from usuario u where login=? and senha=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setString(1, login);
			find.setString(2, senha);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				user.setId(rs.getLong(1));
				user.setLogin(rs.getString(2));
				user.setSenha(rs.getString(3));
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

		return user;
	}

	public void update(Usuario user) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update usuario set login=?, senha=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, user.getLogin());
			update.setString(2, user.getSenha());
			update.setLong(3, user.getId());
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
		String sql = "delete from usuario where id=?";
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
