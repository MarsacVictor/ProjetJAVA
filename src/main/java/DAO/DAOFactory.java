package DAO;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAODB();
	}
}
	