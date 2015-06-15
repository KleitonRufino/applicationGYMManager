package br.com.service;

import java.util.List;

import br.com.model.Product;

public interface IManagerProduct {
	
	public void save(Product p, Long idFornecedor);
	public List<Product> findByIdFornecedor(Long idFuncionario);
}
