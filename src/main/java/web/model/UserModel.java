package web.model;

import java.util.ArrayList;
import java.util.List;

import metier.entities.User;

public class UserModel {

	private int id;
	private String email;
	private String password;
	private String keyword;
	List<User> users = new ArrayList<>();
	
	public UserModel() {
	}		

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
