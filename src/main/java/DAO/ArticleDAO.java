package DAO;
import Class.ArticleVendu;
import Class.Retrait;

public interface ArticleDAO {
	public ArticleVendu selectArticle();
	public void insertArticle(Retrait r);
}
