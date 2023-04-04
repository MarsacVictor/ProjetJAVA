package Manager;

import DAO.DAOFactory;
import DAO.UtilisateurDAO;
import Class.Utilisateur;

public class UtilisateurManager {
	private UtilisateurDAO UtilisateurDAO;
	
	public UtilisateurManager() {
		this.UtilisateurDAO=DAOFactory.getListeCourseDAO();
	}
	
	public void AjouterUtilisateur(String pseudo, String email, String mdp) {
		Utilisateur u = new Utilisateur(pseudo, null, null, email, null, null, null, null, mdp, null, 'U');
		this.UtilisateurDAO.insertUtilisateur(u);
	}
}
