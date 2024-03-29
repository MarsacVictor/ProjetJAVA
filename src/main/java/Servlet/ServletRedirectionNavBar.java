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

import Class.ArticleVendu;
import Class.Categorie;
import Class.Utilisateur;
import Manager.ArticleManager;
import Manager.CategorieManager;
import Manager.UtilisateurManager;

/**
 * Servlet implementation class ServletRedirectionNavBar
 */
@WebServlet(
		urlPatterns= {
						"/DirectionEncheres",
						"/DirectionConnexion",
						"/DirectionInscription",
						"/DirectionVendreUnArticle",
						"/DirectionMonProfil",
						"/DirectionAccueil",
						"/DirectionDeconnexion",
						"/modifierProfil",
						"/DirectionProfilUtilisateur"
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
			 List<ArticleVendu> articles = null;
			 HttpSession session = request.getSession();
			 ArticleManager articleManager = new ArticleManager();
			 UtilisateurManager utilisateurManager = new UtilisateurManager();
			 Utilisateur u = utilisateurManager.selectionnerUtilisateur(((String)session.getAttribute("identifiant")));
			 if(articleManager.existeMesEnchere(u.getNo_utilisateur())) {
				 articles = articleManager.mesArticle(u.getNo_utilisateur());
			 } else {
				 request.setAttribute("error", "Vous n'avez pas crée d'article");	
			 }
			 request.setAttribute("articles", articles);	
	         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/mesEncheres.jsp");
			 rd.forward(request, response);
	     }
		 else if(request.getServletPath().equals("/DirectionVendreUnArticle")){
			HttpSession session = request.getSession();
			UtilisateurManager utilisateurManager = new UtilisateurManager();			
			Utilisateur u = utilisateurManager.selectionnerUtilisateur((String)session.getAttribute("identifiant"));
			request.setAttribute("pseudo", u.getPseudo());
			request.setAttribute("code_postal", u.getCode_postal());
			request.setAttribute("ville", u.getVille());
			request.setAttribute("rue", u.getRue());
			CategorieManager CategorieManager = new CategorieManager();			
			List<Categorie> listC = CategorieManager.selectionnerAllCategorie();
			request.setAttribute("listCategorie", listC);
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
			 request.setAttribute("rue", u.getRue());
			 
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherMonProfil.jsp");
			 rd.forward(request, response); 
	     }
		 else if(request.getServletPath().equals("/DirectionDeconnexion")){
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deconnexion.jsp");
			rd.forward(request, response); 
	     }
		 else if(request.getServletPath().equals("/DirectionAccueil")){
			 CategorieManager CategorieManager = new CategorieManager();			
			 List<Categorie> listC = CategorieManager.selectionnerAllCategorie();
			 ArticleManager ArticleManager = new ArticleManager();	
			    List<ArticleVendu> articles = ArticleManager.getArticleDAO();
			    
			    request.setAttribute("articles", articles);	
			 request.setAttribute("listCategorie", listC);
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response); 
	     }
		
		 else if(request.getServletPath().equals("/DirectionProfilUtilisateur")){
			 UtilisateurManager utilisateurManager = new UtilisateurManager();
			 Utilisateur u = utilisateurManager.selectUtilisateurByID(Integer.parseInt(request.getQueryString()));
	    	 
			request.setAttribute("pseudo", u.getPseudo());;
			request.setAttribute("prenom", u.getPrenom());
			request.setAttribute("nom", u.getNom());
			request.setAttribute("code_postal", u.getCode_postal());
			request.setAttribute("ville", u.getVille());
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherProfilUtilisateur.jsp");
			rd.forward(request, response); 
	     }
		 
		 
		 
		 else if(request.getServletPath().equals("/DirectionInscription")){
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
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
