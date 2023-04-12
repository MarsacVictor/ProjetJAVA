package Manager;

import DAO.DAOFactory;
import DAO.*;

public class EnchereManager {
	
private EnchereDAO EnchereDAO;
	
	public EnchereManager() {
		this.EnchereDAO=DAOFactory.getEnchereDAO();
	}
}
