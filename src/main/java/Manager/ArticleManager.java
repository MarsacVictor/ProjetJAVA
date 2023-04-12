package Manager;

import java.util.Date;
import java.util.List;

import Class.ArticleVendu;
import Class.Categorie;
import Class.Utilisateur;
import Class.Retrait;
import DAO.ArticleDAO;
import DAO.DAOFactory;

public class ArticleManager {
	private ArticleDAO ArticleDAO;

	public ArticleManager() {
		this.ArticleDAO=DAOFactory.getArticleDAO();
	}

	public void insertArticle(String article, String description, String categorie, int prix, Date dateStart,
			Date dateEnd, String rue, String code_postal, String ville, Utilisateur u) {
		// TODO Auto-generated method stub
		ArticleVendu a = new ArticleVendu(article, description, dateStart,dateEnd,prix, prix, u, new Categorie(categorie));
		Retrait r = new Retrait(rue, code_postal, ville, a);
		this.ArticleDAO.insertArticle(r);
	}
	
	public List<ArticleVendu> getArticleDAO() {
		return this.ArticleDAO.selectAllArticle();
	}

	
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		ArticleDAO = articleDAO;
	}

	public ArticleVendu selectArticleID(int id) {
		// TODO Auto-generated method stub
		return this.ArticleDAO.selectArticleId(id);
	}

	public Retrait selectRetraitID(int id) {
		// TODO Auto-generated method stub
		return this.ArticleDAO.selectRetraitId(id);
	}

	public void updateCreditArticle(int noArticle, int credit) {
		// TODO Auto-generated method stub
		this.ArticleDAO.updateCreditArticle(noArticle, credit);
	}

}
