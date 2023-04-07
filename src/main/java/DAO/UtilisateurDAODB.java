package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Class.Utilisateur;

public class UtilisateurDAODB implements UtilisateurDAO {
	
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String CONNEXION = "select pseudo, email, mot_de_passe from UTILISATEURS where (pseudo = ? or email = ?) and mot_de_passe = ? ";
	private static final String SELECT_ALL = "select * from UTILISATEURS";
	private static final String SELECT_BY_ID = "select * from UTILISATEURS where pseudo = ? or email = ?";
	private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?  WHERE pseudo = ? and email = ?";
	
	@Override
	public boolean insertUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		boolean notInsert = false;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				
				List<Utilisateur> listesUtilisateur = new ArrayList<Utilisateur>();
				listesUtilisateur = this.selectAll();
				for (Utilisateur u : listesUtilisateur) {
		            if(u.getEmail().equals(utilisateur.getEmail()) || u.getPseudo().equals(utilisateur.getPseudo())) {
		            	notInsert = true;
		            }
		        }
				if(!notInsert) {
					cnx.setAutoCommit(false);
					PreparedStatement pstmt;
					ResultSet rs;
					pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, utilisateur.getPseudo());
					pstmt.setString(2, utilisateur.getNom());
					pstmt.setString(3, utilisateur.getPrenom());			
					pstmt.setString(4, utilisateur.getEmail());
					pstmt.setString(5, utilisateur.getTelephone());
					pstmt.setString(6, utilisateur.getRue());
					pstmt.setString(7, utilisateur.getCode_postal());
					pstmt.setString(8, utilisateur.getVille());
					pstmt.setString(9, utilisateur.getMot_de_passe());	
					pstmt.setInt(10, 100);
					if (utilisateur.getAdministrateur() == '0') {
						pstmt.setBoolean(11, false);	
					} else {
						pstmt.setBoolean(11, true);
					}
					pstmt.setBoolean(11, true);
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					if(rs.next())
					{
						utilisateur.setNo_utilisateur(rs.getInt(1));
					}
					rs.close();
					pstmt.close();
					cnx.commit();
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
		return notInsert;
	}

	@Override
	public void deleteUtilisateur(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> selectAll() {
		// TODO Auto-generated method stub
		List<Utilisateur> listesUtilisateur = new ArrayList<Utilisateur>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				listesUtilisateur.add(new Utilisateur(rs.getString("pseudo"), rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"),rs.getString("mot_de_passe"),rs.getInt("credit"),'0'));				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listesUtilisateur;
	}

	@Override
	public Utilisateur selectById(String identifiant) {
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
				pstmt.setString(1, identifiant);
				pstmt.setString(2, identifiant);
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
	public void updateUtilisateur(String pseudo, String email, String pseudo2, String prenom, String email2,String telephone, String rue, String code_postal, String ville, String newMdp) {
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			pstmt.setString(1, pseudo2);
			pstmt.setString(2, prenom);
			pstmt.setString(3, email2);
			pstmt.setString(4, telephone);
			pstmt.setString(5, rue);
			pstmt.setString(6, code_postal);
			pstmt.setString(7, ville);
			pstmt.setString(8, newMdp);
			pstmt.setString(9, pseudo);
			pstmt.setString(10, email);			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean connexion(String identifiant, String mdp) {
		// TODO Auto-generated method stub
		boolean trouve=false;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				pstmt = cnx.prepareStatement(CONNEXION);
				pstmt.setString(1, identifiant);
				pstmt.setString(2, identifiant);
				pstmt.setString(3, mdp);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					trouve=true;
				}
				rs.close();
				pstmt.close();
				cnx.commit();
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
		return trouve;
	}
}

