package ca.mcmaster.estore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import ca.mcmaster.estore.domain.Products;
import ca.mcmaster.estore.utils.DataSourceUtils;

public class ProductUploadDao {

	public void addProduct(Products product) throws SQLException {
		String sql = "insert into products values(?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, product.getId(), product.getName(),
				product.getPrice(), product.getCategory(), product.getPnum(),
				product.getImgurl(), product.getDescription());
	}

}
