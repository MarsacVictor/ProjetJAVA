package Servlet;

import Manager.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import Class.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/servletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("mot_de_passe").equals(request.getParameter("confirmation"))) {
			
			HttpSession session = request.getSession();		
			
			String pseudo="";
			String nom ="";
			String prenom ="";
			String email="";
			String telephone ="";
			String rue ="";
			String code_postal ="";
			String ville ="";
			String mdp="";
			int credit = 0;
			
			pseudo = request.getParameter("pseudo");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			telephone = request.getParameter("telephone");
			rue = request.getParameter("rue");
			code_postal = request.getParameter("code_postal");
			ville = request.getParameter("ville");
			mdp = request.getParameter("mot_de_passe");
			credit = 100;

			
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			utilisateurManager.AjouterUtilisateur(pseudo,nom, prenom, email,telephone, rue, code_postal, ville, mdp, credit);
			
			Utilisateur u = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mdp, credit, '0');
			
			session.setAttribute("utilisateur", u);
			session.setMaxInactiveInterval(300);
			System.out.println(u.getEmail());
			request.setAttribute("utilisateur", u);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			System.err.println("Les deux mots de passe sont différent !");
			rd.forward(request, response);
		}	
	}

	
	
	
}
