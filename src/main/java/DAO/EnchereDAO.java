package DAO;

import Class.*;

public interface EnchereDAO {
	public ArticleVendu selectArticle();
	public void insertEnchere(int id, Utilisateur u );
}
