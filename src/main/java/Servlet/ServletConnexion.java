package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import Class.Categorie;
import Manager.CategorieManager;
import Manager.UtilisateurManager;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet(
		urlPatterns= {
						"/servletConn",
						"/servletInscription"
		})
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if(request.getServletPath().equals("/servletInscription")){
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			rd.forward(request, response); 
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategorieManager CategorieManager = new CategorieManager();			
		List<Categorie> listC = CategorieManager.selectionnerAllCategorie();
		request.setAttribute("listCategorie", listC);
		 if(request.getServletPath().equals("/servletConn")) {
			 RequestDispatcher rd;
				String identifiant="";
				String mdp="";
				
				identifiant = request.getParameter("identifiant");
				mdp = request.getParameter("motdepasse");
				
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				if(utilisateurManager.ConnexionUtilisateur(identifiant, mdp)) {
					HttpSession session = request.getSession();
					session.setAttribute("identifiant", identifiant);
					session.setMaxInactiveInterval(300);
					request.setAttribute("identifiant", identifiant);
					rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				} else {
					request.setAttribute("error", "Mauvais identifiant ou mot de passe !");
					rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
				}	
				rd.forward(request, response);
		 }
	}

}
