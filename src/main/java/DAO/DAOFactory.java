package DAO;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getListeCourseDAO()
	{
		return new UtilisateurDAODB();
	}
}
	