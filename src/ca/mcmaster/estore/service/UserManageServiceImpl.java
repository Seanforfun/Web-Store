package ca.mcmaster.estore.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import ca.mcmaster.estore.dao.UserManageDao;
import ca.mcmaster.estore.domain.User;
import ca.mcmaster.estore.exceptions.UserManageExceptions;
import ca.mcmaster.estore.utils.MailUtils;

public class UserManageServiceImpl implements UserManageService {

	@Override
	public void addUser(User u) {
		UserManageDao dao = new UserManageDao();
		try {
			dao.registerUser(u);
			MailUtils.sendActiveEmail(u);
		} catch (SQLException | MessagingException e) {
				throw new UserManageExceptions("Register failed!"+ e.getMessage());
		}
		return;
	}

	@Override
	public void activeUser(String code) {
		UserManageDao dao = new UserManageDao();
		try {
			User u = dao.searchUser(code);

			if (null != u) {
				long past = u.getUpdatetime().getTime();
				long current = System.currentTimeMillis();
				System.out.println(current - past);
				if ((current - past) <= 10 * 60 * 1000) {
					dao.activeUser(code);
				}else{
					throw new UserManageExceptions("Activitive e-mail expired!");
				}
			}else{
				throw new UserManageExceptions("User does't exist!");
			}
		} catch (SQLException e) {
			throw new UserManageExceptions("Active Failed!" + e.getMessage());
		}
	}
}
