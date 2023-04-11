package DAO;

import java.util.List;
import Class.Utilisateur;

public interface UtilisateurDAO {
	
	public boolean insertUtilisateur (Utilisateur utilisateur);
	public void deleteUtilisateur(int id);
	public List<Utilisateur> selectAll();
	public Utilisateur selectById(String identifiant);
	public void updateUtilisateur(String pseudo, String email, String pseudo2, String prenom, String email2,String telephone, String rue, String code_postal, String ville, String newMdp);
	public boolean connexion(String identifiant, String mdp);
	public void supprimerUtilisateur(String pseudo);
}
