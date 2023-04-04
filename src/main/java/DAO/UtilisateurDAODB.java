package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Class.Utilisateur;

public class UtilisateurDAODB implements UtilisateurDAO {
	
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEUR(pseudo, nom, mot_de_passe) values(?, ?, ?);";

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
					pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, utilisateur.getPseudo());
					pstmt.setString(2, utilisateur.getEmail());
					pstmt.setString(3, utilisateur.getMot_de_passe());
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
	}

	@Override
	public void deleteUtilisateur(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUtilisateur(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
