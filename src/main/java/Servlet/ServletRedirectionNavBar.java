package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Class.Utilisateur;
import Manager.UtilisateurManager;

/**
 * Servlet implementation class ServletRedirectionNavBar
 */
@WebServlet(
		urlPatterns= {
						"/DirectionEncheres",
						"/DirectionConnexion",
						"/DirectionVendreUnArticle",
						"/DirectionMonProfil",
						"/DirectionAccueil",
						"/DirectionDeconnexion",
						"/modifierProfil"
		})
public class ServletRedirectionNavBar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRedirectionNavBar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if(request.getServletPath().equals("/DirectionEncheres")) {
	        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
	     }
		 else if(request.getServletPath().equals("/DirectionVendreUnArticle")){
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp");
			rd.forward(request, response); 
	     }
		 else if(request.getServletPath().equals("/DirectionMonProfil")){
			 HttpSession session = request.getSession();
			 
			 UtilisateurManager utilisateurManager = new UtilisateurManager();			
			 Utilisateur u = utilisateurManager.selectionnerUtilisateur((String)session.getAttribute("identifiant"));
			 request.setAttribute("pseudo", u.getPseudo());
			 request.setAttribute("nom", u.getNom());
			 request.setAttribute("prenom", u.getPrenom());
			 request.setAttribute("code_postal", u.getCode_postal());
			 request.setAttribute("ville", u.getVille());
			 
			 
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherMonProfil.jsp");
			 rd.forward(request, response); 
	     }
		 else if(request.getServletPath().equals("/DirectionDeconnexion")){
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deconnexion.jsp");
			rd.forward(request, response); 
	     }
		 else if(request.getServletPath().equals("/DirectionAccueil")){
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response); 
	     }
		 else if(request.getServletPath().equals("/DirectionConnexion")){
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
			rd.forward(request, response); 
	     } else if(request.getServletPath().equals("/modifierProfil")){
	    	 HttpSession session = request.getSession();
			 
			 UtilisateurManager utilisateurManager = new UtilisateurManager();			
			 Utilisateur u = utilisateurManager.selectionnerUtilisateur((String)session.getAttribute("identifiant"));
			 request.setAttribute("pseudo", u.getPseudo());
			 request.setAttribute("nom", u.getNom());
			 request.setAttribute("prenom", u.getPrenom());
			 request.setAttribute("email", u.getEmail());
			 request.setAttribute("telephone", u.getTelephone());
			 request.setAttribute("code_postal", u.getCode_postal());
			 request.setAttribute("rue", u.getRue());
			 request.setAttribute("ville", u.getVille());
			 request.setAttribute("mot_de_passe", u.getMot_de_passe());
			 request.setAttribute("credit", u.getCredit());
			 
	    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
			rd.forward(request, response);
	     }
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
