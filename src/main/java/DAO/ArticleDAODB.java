package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Class.ArticleVendu;
import Class.Retrait;

public class ArticleDAODB implements ArticleDAO{
	
	private static final String INSERT_ARTICLE = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String INSERT_RETRAIT = "insert into UTILISATEURS(no_article, rue, code_postal, ville) values(?, ?, ?, ?);";
	private static final String SELECT_LAST_ROW = "SELECT MAX(no_article) FROM ARTICLES_VENDUS";
	private static final String SELECT_UTILISATEUR_BY_ID = "SELECT no_utilisateur FROM UTILISATEURS WHERE pseudo= ? or email= ?";
	private static final String SELECT_CATEGORIE_BY_ID = "SELECT no_categorie FROM CATEGORIES WHERE libelle= ?";
	
	@Override
	public void insertArticle(Retrait r) {
		// TODO Auto-generated method stub
		int noUtilisateur;
		int noCategorie;
		ArticleVendu article = r.getArticle();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try {
				noCategorie = this.selectIDCategorie(r.getArticle().getCategorie().getLibelle());
				noUtilisateur = this.selectIDUtilisateur(r.getArticle().getUtilisateur().getPseudo());
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, r.getArticle().getNomArticle());
				pstmt.setString(2, r.getArticle().getDescription());
				pstmt.setDate(3, (Date) r.getArticle().getDateDebutEncheres());
				pstmt.setDate(4, (Date) r.getArticle().getDateFinEncheres());
				pstmt.setInt(5, r.getArticle().getPrixInitial());
				pstmt.setInt(6, r.getArticle().getPrixVente());
				pstmt.setInt(7, noUtilisateur);
				pstmt.setInt(8, noCategorie);
				
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					article.setNoArticle(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				
				PreparedStatement pstmt2;
				ResultSet rs2;
				pstmt2 = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt2.setString(1, r.getArticle().getNomArticle());
				pstmt2.setString(2, r.getArticle().getDescription());
				pstmt2.setDate(3, (Date) r.getArticle().getDateDebutEncheres());
				pstmt2.setDate(4, (Date) r.getArticle().getDateFinEncheres());
				pstmt2.executeUpdate();
				rs2 = pstmt.getGeneratedKeys();
				rs2.close();
				pstmt2.close();
				
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
	public int selectIDUtilisateur(String pseudo) {
		int u = 0;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_ID);
				pstmt.setString(1, pseudo);
				pstmt.setString(2, pseudo);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					u = rs.getInt("no_utilisateur");
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
	public int selectIDCategorie(String libelle) {
		int u = 0;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_CATEGORIE_BY_ID);
				pstmt.setString(1, libelle);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					u = rs.getInt("no_categorie");
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

}
