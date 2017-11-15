package ca.mcmaster.estore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import ca.mcmaster.estore.domain.User;
import ca.mcmaster.estore.utils.DataSourceUtils;
import ca.mcmaster.estore.utils.MD5Utils;

public class LoginDao {

	public User login(User u) throws SQLException {
		String sql = "Select * from users where username=? and password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		User ret = runner.query(sql, new BeanHandler<User>(User.class), u.getUsername(), MD5Utils.md5(u.getPassword()));
		return ret;
	}

}
