package DAO;

import Class.*;

public interface EnchereDAO {
	public ArticleVendu selectArticle();
	public void insertEnchere(ArticleVendu id, Utilisateur u, int credit );
}
