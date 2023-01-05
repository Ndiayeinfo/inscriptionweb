package metier.entities;

import java.io.Serializable;
import java.util.Date;

public class Inscription implements Serializable {

	private int id;
	private Date date;
	private String classe;
	private User user;

	public Inscription() {
	}

	public Inscription(Date date, String classe) {
		this.date = date;
		this.classe = classe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Inscription [id=" + id + ", date=" + date + ", classe=" + classe + ", user=" + user + "]";
	}
}
