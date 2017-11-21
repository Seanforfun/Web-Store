package ca.mcmaster.estore.service;

import java.sql.SQLException;
import java.util.List;

import ca.mcmaster.estore.dao.ProductManageDao;
import ca.mcmaster.estore.dao.ProductUploadDao;
import ca.mcmaster.estore.domain.Products;
import ca.mcmaster.estore.exceptions.ProductManageException;

public class ProductManageImpl implements ProductManageService {

	@Override
	public void addProduct(Products product) {
		ProductUploadDao dao = new ProductUploadDao();
		try {
			dao.addProduct(product);
		} catch (SQLException e) {
			throw new ProductManageException("add product error" + e.getMessage());
		}
		return;
	}

	@Override
	public List<Products> findAllProducts() {
		ProductManageDao dao = new ProductManageDao();
		List<Products> list = null;
		try {
			list = dao.findAllProducts();
		} catch (SQLException e) {
			throw new ProductManageException("Find all product exception!" + e.getMessage());
		}
		return list;
	}

	@Override
	public Products getProductById(String id) {
		ProductManageDao dao = new ProductManageDao();
		Products p = null;
		try {
			p = dao.getProductById(id);
		} catch (SQLException e) {
			throw new ProductManageException("getProductById Exception" + e.getMessage());
		}
		return p;
	}

}
