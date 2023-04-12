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
import Manager.ArticleManager;
import Manager.CategorieManager;
import Manager.UtilisateurManager;

/**
 * Servlet implementation class ServletSuppressionCompte
 */
@WebServlet(
		urlPatterns= {
						"/suppression",
						"/RedirectionSuppression"
		})
public class ServletSuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSuppressionCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getServletPath().equals("/RedirectionSuppression")) {
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/supprimerCompte.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/suppression")){
			CategorieManager CategorieManager = new CategorieManager();			
			List<Categorie> listC = CategorieManager.selectionnerAllCategorie();
			ArticleManager ArticleManager = new ArticleManager();	
		    List<ArticleVendu> articles = ArticleManager.getArticleDAO();
		    
		    request.setAttribute("articles", articles);	
			request.setAttribute("listCategorie", listC);
			HttpSession session = request.getSession();
			UtilisateurManager utilisateurManager = new UtilisateurManager();	
			utilisateurManager.supprimerUtilisateur((String)session.getAttribute("identifiant"));
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
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
