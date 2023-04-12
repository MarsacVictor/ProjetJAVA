package Manager;

import DAO.DAOFactory;
import Class.ArticleVendu;
import Class.Utilisateur;
import DAO.*;

public class EnchereManager {
	
private EnchereDAO EnchereDAO;
	
	public EnchereManager() {
		this.EnchereDAO=DAOFactory.getEnchereDAO();
	}

	public void encheri(Utilisateur u, ArticleVendu av, int credit) {
		// TODO Auto-generated method stub
		this.EnchereDAO.insertEnchere(av, u, credit);
	}
}
