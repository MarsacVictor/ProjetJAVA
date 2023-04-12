package DAO;

public abstract class DAOFactory {
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAODB();
	}
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAODB();
	}
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAODB();
	}
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAODB();
	}
}
	