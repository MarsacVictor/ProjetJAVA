package DAO;

import Class.ArticleVendu;
import Class.Enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Class.Utilisateur;

public class EnchereDAODB implements EnchereDAO{

	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES(no_utilisateur, no_article,date_enchere,montant_enchere) VALUES (?,?,?,?)";
	private static final String SELECT_UTILISATEUR_ENCHERE = "SELECT * FROM ENCHERES WHERE no_utilisateur=? AND no_article=?";
	private static final String UPDATE_ENCHERE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=? WHERE no_utilisateur=? and no_article=?";
	private static final String SELECT_ALL_ENCHERE= "SELECT * from ENCHERES WHERE not no_utilisateur=? and no_article=?";
	private static final String SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SELECT_NOT_MAX = "SELECT * FROM ENCHERES where no_utilisateur=? and no_article=? and montant_enchere = (select max(montant_enchere) from ENCHERES where no_article = ?)";
	private static final String SELECT_ENCHERE_IDAV = "SELECT * FROM ENCHERES WHERE no_article=?" ;
	private static final String SELECT_ENCHERE_MAX = "SELECT * FROM ENCHERES where montant_enchere = (select max(montant_enchere) from ENCHERES where no_article = ?)";

	
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
	public ArticleVendu selectArticle(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean uDejaEncheri(int idU, int idAV) {
		boolean dejaEncheri = false;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_ENCHERE);
				pstmt.setInt(1, idU);
				pstmt.setInt(2, idAV);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					dejaEncheri = true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}

		return dejaEncheri;
	}

	@Override
	public void updateEnchere(int no_utilisateur, int noArticle, int credit) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
			pstmt.setObject(1, date);
			pstmt.setInt(2, credit);
			pstmt.setInt(3, no_utilisateur);
			pstmt.setInt(4, noArticle);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean DejaEncheri(int idU, int idAV) {
		boolean dejaEncheri = false;		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_ALL_ENCHERE);
				pstmt.setInt(1, idU);
				pstmt.setInt(2, idAV);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					dejaEncheri = true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}

		return dejaEncheri;
	}

	@Override
	public Enchere enchereARembourser(int idU, int idAV) {
		Enchere e = null;
		Utilisateur u;
		ArticleVendu av = new ArticleVendu();
		int credit = 0;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_ALL_ENCHERE);
				pstmt.setInt(1, idU);
				pstmt.setInt(2, idAV);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					
					if(credit < rs.getInt("montant_enchere")) {
						credit = rs.getInt("montant_enchere");
						u = this.selectUtilisateur(rs.getInt("no_utilisateur"));
						u.setCredit(credit + u.getCredit());
						av.setNoArticle(rs.getInt("no_article"));
						e = new Enchere(u, av, rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
					}
					
				}
			}
			catch(Exception t)
			{
				t.printStackTrace();
				cnx.rollback();
				throw t;
			}
		}
		catch(Exception t)
		{
			t.printStackTrace();			
		}
		return e;
		
	}

	private Utilisateur selectUtilisateur(int int1) {
		// TODO Auto-generated method stub
		Utilisateur u = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_UTILISATEUR);
				pstmt.setInt(1, int1);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					u = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"),rs.getString("mot_de_passe"),rs.getInt("credit"),'0');;
					u.setNo_utilisateur(int1);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		return u;
	}

	@Override
	public boolean utilisateurDejaEncheriMax(int no_utilisateur, int noArticle) {
		boolean dejaEncheri = false;		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_NOT_MAX);
				pstmt.setInt(1, no_utilisateur);
				pstmt.setInt(2, noArticle);
				pstmt.setInt(3, noArticle);
				pstmt.setInt(4, noArticle);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					dejaEncheri = true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}

		return dejaEncheri;
	}

	@Override
	public boolean enchereArticle(int idAV) {
		// TODO Auto-generated method stub
		boolean dejaEncheri = false;		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_ENCHERE_IDAV);
				pstmt.setInt(1, idAV);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					dejaEncheri = true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		return dejaEncheri;
	}

	@Override
	public int idRemporte(int noArticle) {
		// TODO Auto-generated method stub
		int id = 0;		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_ENCHERE_MAX);
				pstmt.setInt(1, noArticle);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					id = rs.getInt("no_utilisateur");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}

		return id;
	}
}