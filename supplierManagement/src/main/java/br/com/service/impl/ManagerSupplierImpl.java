package br.com.service.impl;

import java.util.List;

import br.com.dao.SupplierDAO;
import br.com.model.Supplier;
import br.com.service.IManagerSupplier;

public class ManagerSupplierImpl implements IManagerSupplier {
	private SupplierDAO dao;

	public ManagerSupplierImpl() {
		this.dao = new SupplierDAO();
	}

	@Override
	public Supplier findById(Long idSupplier) {
		return this.dao.findById(idSupplier);
	}

	@Override
	public Supplier findByName(String nomeSupplier) {
		return this.dao.findByName(nomeSupplier);
	}

	public void addSupplier(Supplier supplier) {
		this.dao.addSupplier(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		this.dao.updateSupplier(supplier);
	}

	@Override
	public void deleteSupplier(Long idSupplier) {
		this.dao.deleteSupplier(idSupplier);
	}

	@Override
	public void addSupplierProduct(Long idSupplier, Long idProduct) {
		this.dao.addSupplierProduct(idSupplier, idProduct);
	}

	@Override
	public List<Supplier> findAll() {
		return this.dao.findAll();
	}

}
