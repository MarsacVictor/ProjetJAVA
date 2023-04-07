package Manager;

import DAO.DAOFactory;
import DAO.CategorieDAO;

import java.util.List;

import Class.Categorie;
import Class.Utilisateur;

public class CategorieManager {
	private CategorieDAO CategorieDAO;
	
	public CategorieManager() {
		this.CategorieDAO=DAOFactory.getCategorieDAO();
	}
	public List<Categorie> selectionnerAllCategorie() {
		return this.CategorieDAO.selectAllCategorie();
	}
}
