package ca.mcmaster.estore.service;

import java.sql.SQLException;

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

}
