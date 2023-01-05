package metier.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Inscription;
import metier.entities.User;

public class InscriptionMetierImpl implements IInscription {

	public int add(Inscription inscription, int idUser) {
		int result = 0;
		Connection connection = Singleton.getConnection();
		String sql = "insert into inscription (date, classe, id_user) values (?, ?, ?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);

			Instant instant = inscription.getDate().toInstant();
			ZoneId zoneId = ZoneId.of("Africa/Tunis");
			ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
			LocalDate localDate = zdt.toLocalDate();
			Date sqlDate = Date.valueOf(localDate);

			pstm.setDate(1, sqlDate);
			pstm.setString(2, inscription.getClasse());
			pstm.setInt(3, idUser);
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
		String sql = "delete from inscription where id = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			result = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public int update(Inscription inscription) {
		int result = 0;
		Connection connection = Singleton.getConnection();
		String sql = "update inscription set date = ?, classe = ?, id_user = ? where id = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			Instant instant = inscription.getDate().toInstant();
			ZoneId zoneId = ZoneId.of("Africa/Tunis");
			ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
			LocalDate localDate = zdt.toLocalDate();
			Date sqlDate = Date.valueOf(localDate);
			
			pstm.setDate(1, sqlDate);
			pstm.setString(2, inscription.getClasse());
			pstm.setInt(3, inscription.getUser().getId());
			pstm.setInt(4, inscription.getId());
			
			result = pstm.executeUpdate();
			
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public Inscription findById(int id) {
		Inscription inscription = null;
		Connection connection = Singleton.getConnection();
		String sql = "select * from inscription where id = ?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				inscription = new Inscription();
				inscription.setId(rs.getInt("id"));
				inscription.setDate(rs.getDate("date"));
				inscription.setClasse(rs.getString("classe"));
				int idUser = rs.getInt("id_user");
				
				String sql2 = "select * from user where id = ?";
				PreparedStatement pstm2 = connection.prepareStatement(sql2);
				pstm2.setInt(1, idUser);
				ResultSet rs2 = pstm2.executeQuery();
				if(rs2.next()) {
					User user = new User();
					user.setId(rs2.getInt("id"));
					user.setEmail(rs2.getString("email"));
					user.setPassword(rs2.getString("password"));
					
					inscription.setUser(user);
					
					pstm2.close();
					rs2.close();
				}
				pstm.close();
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inscription;
	}

	
	public List<Inscription> findAll() {
		List<Inscription> inscriptions = new ArrayList();
		Connection connection = Singleton.getConnection();
		String sql = "select * from inscription";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				IUser iuser = new UserMetierImpl();
				Inscription inscription = new Inscription();	
				inscription.setId(rs.getInt("id"));
				inscription.setDate(Date.valueOf(rs.getString("date")));
				inscription.setClasse(rs.getString("classe"));
				inscription.setUser(iuser.findById(rs.getInt("id_user")));
				inscriptions.add(inscription);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inscriptions;
	}

}
