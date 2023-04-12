package DAO;

import Class.ArticleVendu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import Class.Utilisateur;

public class EnchereDAODB implements EnchereDAO{

	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES(no_utilisateur, no_article,date_enchere,montant_enchere) VALUES (?,?,?,?)";
	
	@Override
	public void insertEnchere(ArticleVendu id, Utilisateur u, int credit) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				pstmt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, u.getNo_utilisateur());
				pstmt.setInt(2, id.getNoArticle());
				pstmt.setObject(3, date);
				pstmt.setInt(4, credit);
				
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
				
			} catch(Exception e) {
				e.printStackTrace();
				cnx.rollback();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		
		
	}

	@Override
	public ArticleVendu selectArticle() {
		// TODO Auto-generated method stub
		return null;
	}



}
