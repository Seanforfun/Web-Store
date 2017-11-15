package ca.mcmaster.estore.service;

import java.sql.SQLException;

import ca.mcmaster.estore.dao.LoginDao;
import ca.mcmaster.estore.domain.User;
import ca.mcmaster.estore.exceptions.LoginException;

public class LoginServiceImpl implements LoginService {

	@Override
	public User login(User u) {
		LoginDao dao = new LoginDao();
		User ret = null;
		try {
			ret = dao.login(u);
			if (null == ret) {
				throw new LoginException("User doesn't exist! Wrong username or password!");
			}
			
			int state = ret.getState();
			if(state == 0){
				throw new LoginException("Please active by e-mail before login!");
			}
		} catch (SQLException e) {
			throw new LoginException("User Login failed: " + e.getMessage());

		}
		return ret;
	}

}
