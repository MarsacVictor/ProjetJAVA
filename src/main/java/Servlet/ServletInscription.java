package Servlet;

import Manager.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
		String pseudo="";
		String email="";
		String mdp="";
		
		pseudo = lireParametrePseudo(request);
		email = lireParametreEmail(request);
		mdp = lireParametreMdp(request);
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		utilisateurManager.AjouterUtilisateur(pseudo, email, mdp);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String lireParametrePseudo(HttpServletRequest request) {
		String pseudo;
		pseudo = request.getParameter("pseudo");
		return pseudo;
	}
	private String lireParametreEmail(HttpServletRequest request) {
		String email;
		email = request.getParameter("email");
		return email;
	}
	private String lireParametreMdp(HttpServletRequest request) {
		String mdp;
		mdp = request.getParameter("mdp");
		return mdp;
	}
	
	
}
