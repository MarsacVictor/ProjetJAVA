package DAO;
import java.util.List;

import Class.ArticleVendu;
import Class.Retrait;
import Class.Utilisateur;

public interface ArticleDAO {
	public ArticleVendu selectArticle();
	public void insertArticle(Retrait r);
	public List<ArticleVendu> selectAllArticle();
	Utilisateur selectById(int identifiant);
}
