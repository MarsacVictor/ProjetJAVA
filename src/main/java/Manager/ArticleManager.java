package Manager;

import java.util.Date;
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
}
