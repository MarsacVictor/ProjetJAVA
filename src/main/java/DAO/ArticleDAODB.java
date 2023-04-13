package DAO;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Class.ArticleVendu;
import Class.Categorie;
import Class.Retrait;
import Class.Utilisateur;

public class ArticleDAODB implements ArticleDAO{
	
	private static final String INSERT_ARTICLE = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String INSERT_RETRAIT = "insert into RETRAITS(no_article, rue, code_postal, ville) values(?, ?, ?, ?);";
	private static final String SELECT_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";
	private static final String SELECT_BY_ID = "select * from UTILISATEURS where no_utilisateur = ?";
	private static final String SELECT_BY_CATEGORIE = "select * FROM CATEGORIES WHERE no_categorie=?";
	private static final String SELECT_UTILISATEUR_BY_ID = "SELECT no_utilisateur FROM UTILISATEURS WHERE pseudo= ? or email= ?";
	private static final String SELECT_CATEGORIE_BY_ID = "SELECT no_categorie FROM CATEGORIES WHERE libelle= ?";
	private static final String SELECT_ARTICLE_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
	private static final String SELECT_RETRAIT_BY_ID = "SELECT * FROM RETRAITS WHERE no_article=?";
	private static final String UPDATE_CREDIT_ARTICLE = "UPDATE ARTICLES_VENDUS SET prix_vente=? WHERE no_article=?";
	
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
				pstmt.setObject(3, r.getArticle().getDateDebutEncheres());
				pstmt.setObject(4, r.getArticle().getDateFinEncheres());
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
				cnx.commit();
				r.setArticle(article);
				this.insertRetrait(r);
				
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
	
	public void insertRetrait(Retrait r) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try {
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, r.getArticle().getNoArticle());
				pstmt.setString(2, r.getArticle().getUtilisateur().getRue());
				pstmt.setString(3, r.getArticle().getUtilisateur().getCode_postal());
				pstmt.setString(4, r.getArticle().getUtilisateur().getVille());
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				rs.close();
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
	public List<ArticleVendu> selectAllArticle() {
		Utilisateur u;
		Categorie ca;
		List<ArticleVendu> articles = new ArrayList<>();
	    try(Connection cnx = ConnectionProvider.getConnection())
	    {
	        try
	        {
	            cnx.setAutoCommit(false);
	            PreparedStatement pstmt;
	            ResultSet rs;
	            pstmt = cnx.prepareStatement(SELECT_ARTICLE);
	            rs = pstmt.executeQuery();
	            while(rs.next())
	            {
	            	u = this.selectById(rs.getInt("no_utilisateur"));
	            	u.setNo_utilisateur(rs.getInt("no_utilisateur"));
	            	ca = this.selectByCat(rs.getInt("no_categorie"));
	                articles.add(new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"),u,ca));
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
	    return articles;
	}
	
	private Categorie selectByCat(int identifiant) {
		Categorie ca = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
				pstmt.setInt(1, identifiant);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ca = new Categorie(rs.getString("libelle"));
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
		return ca;
	}

	@Override
	public Utilisateur selectById(int identifiant) {
		// TODO Auto-generated method stub
		Utilisateur u = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_BY_ID);
				pstmt.setInt(1, identifiant);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					u = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"),rs.getString("mot_de_passe"),rs.getInt("credit"),'0');
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
	public ArticleVendu selectArticleId(int id) {
		ArticleVendu av = null;
		Utilisateur u;
		Categorie ca;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_ARTICLE_BY_ID);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					u = this.selectById(rs.getInt("no_utilisateur"));
	            	ca = this.selectByCat(rs.getInt("no_categorie"));
					av = new ArticleVendu(rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"), u, ca);
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
		return av;
	}


	@Override
	public Retrait selectRetraitId(int id) {
		Retrait r = null;
		ArticleVendu av = this.selectArticleId(id);
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(SELECT_RETRAIT_BY_ID);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{				
					r = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), av);
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
		return r;
	}


	@Override
	public void updateCreditArticle(int noArticle, int credit) {
		// TODO Auto-generated method stub
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_CREDIT_ARTICLE);
			pstmt.setInt(1, credit);
			pstmt.setInt(2, noArticle);		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
