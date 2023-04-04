package DAO;

import java.util.List;

import Class.Utilisateur;

public interface UtilisateurDAO {
	
	public void insertUtilisateur (Utilisateur utilisateur);
	public void deleteUtilisateur(int id);
	public List<Utilisateur> selectAll();
	public Utilisateur selectById(int id);
	public void updateUtilisateur(int id);
	
}
