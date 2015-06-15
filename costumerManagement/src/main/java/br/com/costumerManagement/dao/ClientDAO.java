package br.com.costumerManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.costumerManagement.model.Client;
import conexao.Conexao;

public class ClientDAO {
	public void save(Client client, Long idUser) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insereSt = null;
		String sql = "insert into cliente(ativo,cpf,telefone,datanascimento,datavencimento,nome,usuario_id) values (?,?,?,?,?,?,?)";
		try {
			insereSt = (PreparedStatement) conexao.prepareStatement(sql);
			insereSt.setBoolean(1, true);
			insereSt.setLong(2, client.getCpf());
			insereSt.setString(3, client.getTelefone());
			insereSt.setDate(4, client.getDataNascimento());
			insereSt.setLong(5, client.getDataVencimento());
			insereSt.setString(6, client.getNome());
			insereSt.setLong(7, idUser);
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

	public Client find(Long id) {
		Client client = new Client();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from cliente c where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				client.setId(rs.getLong("id"));
				client.setAtivo(rs.getBoolean("ativo"));
				client.setCpf(rs.getLong("cpf"));
				client.setDataNascimento(rs.getDate("datanascimento"));
				client.setDataVencimento(rs.getLong("datavencimento"));
				client.setTelefone(rs.getString("telefone"));
				client.setNome(rs.getString("nome"));
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

		return client;
	}

	public List<Client> findAll() {
		Client client;
		List<Client> clients = new ArrayList<Client>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from cliente";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				client = new Client();
				client.setId(rs.getLong("id"));
				client.setAtivo(rs.getBoolean("ativo"));
				client.setCpf(rs.getLong("cpf"));
				client.setDataNascimento(rs.getDate("datanascimento"));
				client.setDataVencimento(rs.getLong("datavencimento"));
				client.setTelefone(rs.getString("telefone"));
				client.setNome(rs.getString("nome"));
				clients.add(client);
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
		return clients;
	}

	public List<Client> findName(String nome) {
		Client client;
		List<Client> clients = new ArrayList<Client>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from cliente c where nome=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setString(1, nome);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				client = new Client();
				client.setId(rs.getLong("id"));
				client.setAtivo(rs.getBoolean("ativo"));
				client.setCpf(rs.getLong("cpf"));
				client.setDataNascimento(rs.getDate("datanascimento"));
				client.setDataVencimento(rs.getLong("datavencimento"));
				client.setTelefone(rs.getString("telefone"));
				client.setNome(rs.getString("nome"));
				clients.add(client);
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
		return clients;
	}

	public void update(Client client) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update cliente set ativo=?, cpf=?,telefone=?, datanascimento=?, datavencimento=?, nome=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setBoolean(1, client.isAtivo());
			update.setLong(2, client.getCpf());
			update.setString(3, client.getTelefone());
			update.setDate(4, client.getDataNascimento());
			update.setLong(5, client.getDataVencimento());
			update.setString(6, client.getNome());
			update.setLong(7, client.getId());
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
		String sql = "delete from cliente where id=?";
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

	public Client findByIdUser(Long idUser) {
		Client client = new Client();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from cliente c where usuario_id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idUser);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				client.setId(rs.getLong("id"));
				client.setAtivo(rs.getBoolean("ativo"));
				client.setCpf(rs.getLong("cpf"));
				client.setTelefone(rs.getString("telefone"));
				client.setDataNascimento(rs.getDate("datanascimento"));
				client.setDataVencimento(rs.getLong("datavencimento"));
				client.setNome(rs.getString("nome"));
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

		return client;
	}

}
