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

import Class.Categorie;
import Class.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet(
		urlPatterns= {
						"/servletCreer",
						"/servletAnnuler"
		})
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
		 if(request.getServletPath().equals("/servletAnnuler")) {
	        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
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
		if(request.getServletPath().equals("/servletCreer")) {
			if(request.getParameter("mot_de_passe").equals(request.getParameter("confirmation"))) {
				
				
				
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
				RequestDispatcher rd = null;
				
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
				if(!utilisateurManager.AjouterUtilisateur(pseudo,nom, prenom, email,telephone, rue, code_postal, ville, mdp, credit)) {
					HttpSession session = request.getSession();
					session.setAttribute("identifiant", pseudo);
					session.setMaxInactiveInterval(300);	
					request.setAttribute("identifiant", pseudo);
					rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
					
				} else {
					request.setAttribute("error2", "L'email ou le pseudo existe déjà !");
					rd.forward(request, response);
					rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
				}
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
				request.setAttribute("error", "Les deux mots de passe sont différent !");
				rd.forward(request, response);
			}
		}
	}

	
	
	
}
