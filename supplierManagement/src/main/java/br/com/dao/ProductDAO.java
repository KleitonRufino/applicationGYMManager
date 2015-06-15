package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Product;
import conexao.Conexao;

public class ProductDAO {

	public Product findById(Long idProduct) {
		Product product = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select id, descricao, preco from produto where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idProduct);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setId(rs.getLong(1));
				product.setDescricao(rs.getString(2));
				product.setPreco(rs.getDouble(3));
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
		return product;
	}

	public Product findByDescricao(String descricaoProduct) {
		Product product = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select id, descricao, preco from produto where descricao=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setString(1, descricaoProduct);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setId(rs.getLong(1));
				product.setDescricao(rs.getString(2));
				product.setPreco(rs.getDouble(3));
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
		return product;
	}

	public void addProduct(Product product, Long idFornecedor) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into produto(descricao, preco, id_fornecedor) values (?,?,?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setString(1, product.getDescricao());
			insere.setDouble(2, product.getPreco());
			insere.setLong(3, idFornecedor);
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

	public List<Product> findByFornecedor(Long idFornecedor) {
		Product product;
		List<Product> products = new ArrayList<Product>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from produto where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idFornecedor);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				product = new Product();
				product.setId(rs.getLong("id"));
				product.setDescricao(rs.getString("descricao"));
				product.setPreco(rs.getDouble("preco"));
				products.add(product);
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
		return products;
	}

	public void updateProduct(Product product) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update produto set descricao=?, preco=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, product.getDescricao());
			update.setDouble(2, product.getPreco());
			update.setLong(3, product.getId());
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

	public void deleteProduct(Long idProduct) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from produto where id=?";
		try {
			delete = (PreparedStatement) conexao.prepareStatement(sql);
			delete.setLong(1, idProduct);
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
