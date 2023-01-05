package presentation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import metier.dao.IInscription;
import metier.dao.IUser;
import metier.dao.InscriptionMetierImpl;
import metier.dao.UserMetierImpl;
import metier.entities.Inscription;
import metier.entities.User;

public class Application {

	public static void main(String[] args) {
		System.out.println("*********************************************************************");
		System.out.println("*BIENVENUE DANS LE SYSTEME DE GESTION DES INSCRIPTIONS DU GROUPE ISI*");
		System.out.println("*********************************************************************");
		System.out.println("\n");

		Scanner scanner = new Scanner(System.in);

		System.out.println("MENU");
		System.out.println("1 - Gestion des utiisateurs");
		System.out.println("2 - Gestion des inscriptions");
		System.out.println("Faites votre choix : ");
		int choice = Integer.parseInt(scanner.nextLine());

		switch (choice) {
		case 1:
			System.out.println("GESTION DES UTILISATEURS");
			System.out.println("1 - Ajouter un utilisateur");
			System.out.println("2 - Supprimer un utilisateur");
			System.out.println("3 - Mettre à jour un utilisateur");
			System.out.println("4 - Rechercher un utilisateur");
			System.out.println("5 - Lister les utilisateurs");
			System.out.println("Faites votre choix : ");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				System.out.println("AJOUTER UN UTILISATEUR");
				System.out.println();
				System.out.print("Saisir e-mail : ");
				String email = scanner.nextLine();
				System.out.print("Saisir password : ");
				String password = scanner.nextLine();
				User user = new User();
				user.setEmail(email);
				user.setPassword(password);

				IUser iuser = new UserMetierImpl();
				int result = iuser.add(user);
				if (result != 0) {
					System.out.println("Utilisateur ajouté avec succès.");
				} else {
					System.out.println("Utilisateur non ajouté.");
				}
				break;
			case 2:
				System.out.println("SUPPRIMER UN UTILISATEUR");
				System.out.println();
				System.out.print("Saisir Identifiant Utilisateur : ");
				int idUser = Integer.parseInt(scanner.nextLine());

				iuser = new UserMetierImpl();
				result = iuser.delete(idUser);
				if (result != 0) {
					System.out.println("Utilisateur supprimé avec succès.");
				} else {
					System.out.println("Echec de la suppression.");
				}
				break;
			case 3:
				System.out.println("METTRE A JOUR UN UTILISATEUR");
				System.out.println();
				System.out.print("Saisir Identifiant Utilisateur : ");
				idUser = Integer.parseInt(scanner.nextLine());
				System.out.print("Saisir e-mail : ");
				email = scanner.nextLine();
				System.out.print("Saisir password : ");
				password = scanner.nextLine();

				user = new User();
				user.setId(idUser);
				user.setEmail(email);
				user.setPassword(password);

				iuser = new UserMetierImpl();
				result = iuser.update(user);
				if (result != 0) {
					System.out.println("La mise à jour de l'utilisateur a été effectué avec succès.");
				} else {
					System.out.println("Echec de la mise à jour.");
				}
				break;
			case 4:
				System.out.println("RECHERCHER UN UTILISATEUR");
				System.out.println();
				System.out.print("Saisir Identifiant Utilisateur : ");
				idUser = Integer.parseInt(scanner.nextLine());

				iuser = new UserMetierImpl();
				user = iuser.findById(idUser);
				if (user != null) {
					System.out.println(user);
				} else {
					System.out.println("Objet introuvable.");
				}
				break;
			case 5:
				System.out.println("LISTE DE TOUS LES UTILISATEURS");
				System.out.println();

				iuser = new UserMetierImpl();
				List<User> users = iuser.findAll();
				if (users != null) {
					for (User u : users) {
						System.out.println(u);
					}
				} else {
					System.out.println("Il n'y pas d'utilisateurs dans la base.");
				}

				break;

			default:
				System.out.println("Choix invalide...");
				break;
			}
			break;
		case 2:
			System.out.println("GESTION DES INSCRIPTIONS");
			System.out.println("1 - Ajouter une inscrpition");
			System.out.println("2 - Supprimer une inscrpition");
			System.out.println("3 - Mettre à jour une inscription");
			System.out.println("4 - Rechercher une inscription");
			System.out.println("5 - Lister les inscriptions");
			System.out.println("Faites votre choix : ");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				System.out.println("1 - AJOUTER UNE INSCRIPTION");
				System.out.print("Saisir Date (Format : AAAA-MM-JJ) : ");
				Date date = null;
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					date = sdf.parse(scanner.nextLine());
					System.out.print("Saisir classe : ");
					String classe = scanner.nextLine();
					System.out.print("Saisir Identifiant Utilisateur : ");
					int idUser = Integer.parseInt(scanner.nextLine());
					IUser iuser = new UserMetierImpl();
					User user = iuser.findById(idUser);
					if (user != null) {
						IInscription iinscription = new InscriptionMetierImpl();
						Inscription inscription = new Inscription();
						inscription.setDate(date);
						inscription.setClasse(classe);
						int result = iinscription.add(inscription, idUser);
						if (result != 0) {
							System.out.println("Utilisateur inscrit avec succes");
						} else {
							System.out.println("Utilisateur non ajouté.");
						}
					} else {
						System.out.println("Utilisateur inexistant. Veuillez d'abord le créer avant de l'ajouter");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("2 - SUPPRIMER UNE INSCRIPTION");
				System.out.print("Saisir Identifiant Inscription à supprimer");
				int idInscription = Integer.parseInt(scanner.nextLine());
				IInscription iinscription = new InscriptionMetierImpl();
				int result = iinscription.delete(idInscription);
				if (result != 0) {
					System.out.println("Inscription supprimée avec succès");
				} else {
					System.out.println("Echec de la suppression de l'inscription");
				}
				break;
			case 3:
				System.out.println("2 - MISE A JOUR D'UNE INSCRIPTION");
				date = null;
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					System.out.print("Saisir Identifiant Inscription : ");
					idInscription = Integer.parseInt(scanner.nextLine());
					System.out.print("Saisir date (AAAA-MM-dd) : ");
					date = sdf.parse(scanner.nextLine());
					System.out.print("Classe : ");
					String classe = scanner.nextLine();
					System.out.print("Saisir Identifiant Utilisateur : ");
					int idUser = Integer.parseInt(scanner.nextLine());

					IUser iuser = new UserMetierImpl();
					User user = iuser.findById(idUser);
					if (user != null) {
						iinscription = new InscriptionMetierImpl();
						Inscription inscription = new Inscription();
						
						inscription.setId(idInscription);
						inscription.setDate(date);
						inscription.setClasse(classe);
						inscription.setUser(user);
						
						result = iinscription.update(inscription);
						
						if (result != 0) {
							System.out.println("Inscription mise à jour avec succès");
						}else {
							System.out.println("Echec de la mise à jour de l'inscription");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.print("4 - Rechercher d'une inscription : ");
				System.out.println();
				System.out.print("Saisir Identifiant Inscription : ");
				int id = Integer.parseInt(scanner.nextLine());
				iinscription = new InscriptionMetierImpl();
				Inscription inscription = iinscription.findById(id);
				if (inscription != null) {
					System.out.println(inscription);
				}else {
					System.out.println("Objet introuvable...");
				}
				break;
			case 5:
				System.out.print("4 - Lister toutes les inscriptions : ");
				System.out.println();
				iinscription = new InscriptionMetierImpl();
				List<Inscription> inscriptions = iinscription.findAll();
				if (inscriptions != null) {
					for (Inscription i : inscriptions) {
						System.out.println(i);
					}
				}else {
					System.out.println("Il n'y a aucun dans la base.");
				}
				break;

			default:
				System.out.println("Choix invalide...");
				break;
			}
			break;

		default:
			System.out.println("Choix invalide...");
			break;
		}
	}
}
