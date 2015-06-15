package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Supplier;
import conexao.Conexao;

public class SupplierDAO {

	public Supplier findById(Long idSupplier) {
		Supplier supplier = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select id, nome from fornecedor where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idSupplier);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				supplier = new Supplier();
				supplier.setId(rs.getLong(1));
				supplier.setNome(rs.getString(2));
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
		return supplier;
	}

	public Supplier findByName(String nomeSupplier) {
		Supplier supplier = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select id, nome from fornecedor where nome=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setString(1, nomeSupplier);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				supplier = new Supplier();
				supplier.setId(rs.getLong(1));
				supplier.setNome(rs.getString(2));
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
		return supplier;
	}

	public void addSupplier(Supplier supplier) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into fornecedor(nome) values (?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setString(1, supplier.getNome());
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

	public void addSupplierProduct(Long idSupplier, Long idProduct) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into fornecedor_produto(fornecedor_id, produtos_id) values (?,?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setLong(1, idSupplier);
			insere.setLong(2, idProduct);
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

	public void updateSupplier(Supplier supplier) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update fornecedor set nome=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, supplier.getNome());
			update.setLong(2, supplier.getId());
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

	public List<Supplier> findAll() {
		Supplier supplier;
		List<Supplier> suppliers = new ArrayList<Supplier>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from fornecedor";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				supplier = new Supplier();
				supplier.setId(rs.getLong("id"));
				supplier.setNome(rs.getString("nome"));
				suppliers.add(supplier);
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
		return suppliers;
	}

	public void deleteSupplier(Long idSupplier) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from fornecedor where id=?";
		try {
			delete = (PreparedStatement) conexao.prepareStatement(sql);
			delete.setLong(1, idSupplier);
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
