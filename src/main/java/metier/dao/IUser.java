package metier.dao;

import java.util.List;

import metier.entities.User;

public interface IUser {

	public int add(User user);
	public int delete(int id);
	public int update(User user);
	public User findById(int id);
	public List<User> findByKeyword(String keyword);
	public List<User> findAll();	
}
