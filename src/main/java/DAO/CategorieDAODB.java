package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import Class.Categorie;

public class CategorieDAODB implements CategorieDAO{
	
	private static final String SELECT_ALL = "select * from CATEGORIES";

	@Override
	public List<Categorie> selectAllCategorie() {
		// TODO Auto-generated method stub
		List<Categorie> listesCategorie = new ArrayList<Categorie>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				listesCategorie.add(new Categorie(rs.getString("libelle")));				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listesCategorie;
	}
}
