package ca.mcmaster.estore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import ca.mcmaster.estore.domain.User;
import ca.mcmaster.estore.utils.ActiveCodeUtils;
import ca.mcmaster.estore.utils.DataSourceUtils;

public class UserManageDao {

	public void registerUser(User u) throws SQLException {
		String sql = "insert into users values(null, ?,?,?,?,?,?,?, null)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, u.getUsername(), u.getPassword(),u.getNickname(),u.getEmail(),"user",0,u.getActivecode());
		return;
	}

	public User searchUser(String code) throws SQLException {
		String sql = "select * from users where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		User u = runner.query(sql, new BeanHandler<User>(User.class), code);
		return u;
	}

	public void activeUser(String code) throws SQLException {
		String sql = "update users set state=1 where activecode =? ";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, code);
	}
	
}
