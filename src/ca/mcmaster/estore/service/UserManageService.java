package ca.mcmaster.estore.service;

import ca.mcmaster.estore.domain.User;

public interface UserManageService {
	public void addUser(User u);
	public void activeUser(String code);
}
