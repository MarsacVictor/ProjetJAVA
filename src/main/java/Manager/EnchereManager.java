package Manager;

import DAO.DAOFactory;
import Class.ArticleVendu;
import Class.Enchere;
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

	public boolean utilisateurDejaEncheri(int idU, int idAV) {
		// TODO Auto-generated method stub
		return this.EnchereDAO.uDejaEncheri(idU, idAV);
	}

	public void updateEnchere(int no_utilisateur, int noArticle, int credit) {
		this.EnchereDAO.updateEnchere(no_utilisateur, noArticle, credit);		
	}

	public boolean dejaEncheri(int idU, int idAV) {
		// TODO Auto-generated method stub
		return this.EnchereDAO.DejaEncheri(idU,idAV);
	}

	public Enchere creditRemboursement(int idU, int idAV) {
		// TODO Auto-generated method stub
		return this.EnchereDAO.enchereARembourser(idU, idAV);
	}

	public boolean utilisateurDejaEncheriMax(int no_utilisateur, int noArticle) {
		// TODO Auto-generated method stub
		return this.EnchereDAO.utilisateurDejaEncheriMax(no_utilisateur, noArticle);
	}
}
