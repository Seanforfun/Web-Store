package ca.mcmaster.estore.service;

import java.util.List;

import ca.mcmaster.estore.domain.Products;

public interface ProductManageService {
	public void addProduct(Products product);
	public List<Products> findAllProducts();
	public Products getProductById(String id);
}
