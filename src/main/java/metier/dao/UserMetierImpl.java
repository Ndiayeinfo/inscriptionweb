package metier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Inscription;
import metier.entities.User;

public class UserMetierImpl implements IUser {

	public int add(User user) {
		int result = 0;
		Connection connection = Singleton.getConnection();
		String sql = "insert into user (email, password) values (?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			result = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int delete(int id) {
		int result = 0;
		Connection connection = Singleton.getConnection();
		String sql = "delete from user where id = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			result = pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(User user) {
		int result = 0;
		Connection connection = Singleton.getConnection();
		String sql = "update user set email = ?, password = ? where id = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			pstm.setInt(3, user.getId());
			result = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public User findById(int id) {
		List<Inscription> inscriptions = new ArrayList();
		User user = null;
		Connection connection = Singleton.getConnection();
		String sql = "select * from user where id = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(id);
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				String sql2 = "select * from inscription where id_user = ?";
				PreparedStatement pstm2 = connection.prepareStatement(sql2);
				pstm2.setInt(1, id);
				ResultSet rs2 = pstm2.executeQuery();
				while (rs2.next()) {
					Inscription inscription = new Inscription();
					inscription.setId(rs2.getInt("id"));
					inscription.setDate(rs2.getDate("date"));
					inscription.setClasse(rs2.getString("classe"));
					inscriptions.add(inscription);
					user.setInscriptions(inscriptions);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> findAll() {
		List<User> users = new ArrayList();
		Connection connection = Singleton.getConnection();
		String sql = "select * from user";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<User> findByKeyword(String keyword) {
		List<User> users = new ArrayList();
		Connection connection = Singleton.getConnection();
		String sql = "select * from user where email like ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, "%"+keyword+"%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
