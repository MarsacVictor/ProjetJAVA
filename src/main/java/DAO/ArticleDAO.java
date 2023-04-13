package DAO;
import java.util.List;

import Class.ArticleVendu;
import Class.Retrait;
import Class.Utilisateur;

public interface ArticleDAO {
	public void insertArticle(Retrait r);
	public List<ArticleVendu> selectAllArticle();
	Utilisateur selectById(int identifiant);
	public ArticleVendu selectArticleId(int id);
	public Retrait selectRetraitId(int id);
	public void updateCreditArticle(int noArticle, int credit);
	public boolean existeMesEnchere(int no_utilisateur);
	public List<ArticleVendu> mesArticle(int no_utilisateur);
	void gagnerEnchere(ArticleVendu av);
}
