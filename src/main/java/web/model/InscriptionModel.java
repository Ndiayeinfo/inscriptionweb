package web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import metier.entities.Inscription;
import metier.entities.User;

public class InscriptionModel {

	private int id;
	private Date date;
	private String classe;
	private User user;
	private List<Inscription> inscriptions = new ArrayList<>();
	
	public InscriptionModel() {
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

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}	
	
}
