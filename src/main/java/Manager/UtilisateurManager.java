package Manager;

import DAO.DAOFactory;
import DAO.UtilisateurDAO;
import Class.Utilisateur;

public class UtilisateurManager {
	private UtilisateurDAO UtilisateurDAO;
	
	public UtilisateurManager() {
		this.UtilisateurDAO=DAOFactory.getUtilisateurDAO();
	}
	
	public boolean AjouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mdp, int credit) {
		Utilisateur u = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mdp, credit, '0');
		return this.UtilisateurDAO.insertUtilisateur(u);
	}
	public boolean ConnexionUtilisateur(String identifiant, String mdp) {
		return this.UtilisateurDAO.connexion(identifiant, mdp);
	}
}
