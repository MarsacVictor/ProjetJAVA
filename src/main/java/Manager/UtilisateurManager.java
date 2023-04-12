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

	public Utilisateur selectionnerUtilisateur(String identifiant) {
		// TODO Auto-generated method stub
		return this.UtilisateurDAO.selectById(identifiant);
	}
	
	public void supprimerUtilisateur(String pseudo) {
		// TODO Auto-generated method stub
		this.UtilisateurDAO.supprimerUtilisateur(pseudo);
	}

	public void modifierMonProfil(String pseudo, String email, String pseudo2, String prenom, String email2,
			String telephone, String rue, String code_postal, String ville, String newMdp) {
			this.UtilisateurDAO.updateUtilisateur(pseudo, email, pseudo2, prenom, email2, telephone,rue,code_postal,ville,newMdp);
		
	}

	public Utilisateur selectUtilisateurByID(int ID) {
		// TODO Auto-generated method stub
		return this.UtilisateurDAO.selectUtilisateurByID(ID);
	}
}
