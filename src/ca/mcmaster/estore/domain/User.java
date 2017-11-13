package ca.mcmaster.estore.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String role;
	private int state;
	private String activecode;
	private Timestamp updatetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getActivecode() {
		return activecode;
	}

	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Map<String, String> validation() {
		Map<String, String> map = new HashMap<>();
		if(username == null || username.trim().length() == 0){
			map.put("register.username.error", "username cannot be empty!");
		}
		if(password == null || password.trim().length() == 0){
			map.put("register.password.error", "password cannot be empty!");
		}
		if(nickname == null || nickname.trim().length() == 0){
			map.put("register.nickname.error", "nickname cannot be empty!");
		}
		if(email == null || email.trim().length() == 0){
			map.put("register.email.error", "email cannot be empty!");
		}
		return map;
	}
}
