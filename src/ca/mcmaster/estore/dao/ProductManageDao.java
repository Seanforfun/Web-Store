package ca.mcmaster.estore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import ca.mcmaster.estore.domain.Products;
import ca.mcmaster.estore.utils.DataSourceUtils;

public class ProductManageDao {

	public List<Products> findAllProducts() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "Select * from products";
		List<Products> list = runner.query(sql, new BeanListHandler<Products>(Products.class));
		return list;
	}

	public Products getProductById(String id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from products where id = ?";
		Products product = runner.query(sql, new BeanHandler<Products>(Products.class), id);
		return product;
	}
	
}
