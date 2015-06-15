package br.com.service.impl;

import java.util.List;

import br.com.dao.ProductDAO;
import br.com.model.Product;
import br.com.service.IManagerProduct;

public class ManagerProduct implements IManagerProduct{
	
	private ProductDAO dao;
	public ManagerProduct() {
		this.dao = new ProductDAO();
	}
	@Override
	public void save(Product p, Long idFornecedor) {
		this.dao.addProduct(p, idFornecedor);
	}

	@Override
	public List<Product> findByIdFornecedor(Long idFornecedor) {
		return this.dao.findByFornecedor(idFornecedor);
	}

}
