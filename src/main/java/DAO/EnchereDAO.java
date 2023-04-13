package DAO;

import Class.*;

public interface EnchereDAO {
	public ArticleVendu selectArticle(int i);
	public void insertEnchere(ArticleVendu id, Utilisateur u, int credit );
	public boolean uDejaEncheri(int idU, int idAV);
	public void updateEnchere(int no_utilisateur, int noArticle, int credit);
	public boolean DejaEncheri(int idU, int idAV);
	public Enchere enchereARembourser(int idU, int idAV);
	public boolean utilisateurDejaEncheriMax(int no_utilisateur, int noArticle);
	public boolean enchereArticle(int idAV);
	public int idRemporte(int noArticle);
}
