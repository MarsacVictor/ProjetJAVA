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

import Class.ArticleVendu;
import Class.Categorie;
import Class.Utilisateur;

/**
 * Servlet implementation class ServletEncherir
 */
@WebServlet("/servletEncherir")
public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEncherir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		RequestDispatcher rd;
		EnchereManager enchereManager = new EnchereManager();
		ArticleManager articleManager = new ArticleManager();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur u = utilisateurManager.selectionnerUtilisateur((String)session.getAttribute("identifiant"));
		ArticleVendu av = articleManager.selectArticleID(((ArticleVendu)session.getAttribute("articleEnchere")).getNoArticle());
		if((u.getCredit() - Integer.parseInt(request.getParameter("credit"))) >= 0 ) {
			if(enchereManager.utilisateurDejaEncheri(u.getNo_utilisateur(), av.getNoArticle())) {
				enchereManager.updateEnchere(u.getNo_utilisateur(), av.getNoArticle(), Integer.parseInt(request.getParameter("credit")));
			} else {
				enchereManager.encheri(u, av, Integer.parseInt(request.getParameter("credit")));
			}
			articleManager.updateCreditArticle(av.getNoArticle(), Integer.parseInt(request.getParameter("credit")));
			if(enchereManager.dejaEncheri(u.getNo_utilisateur(), av.getNoArticle())) {
				utilisateurManager.recuperationCredit(enchereManager.creditRemboursement(u.getNo_utilisateur(), av.getNoArticle()));
			}
			utilisateurManager.updateCredit(u.getPseudo(), u.getCredit() - Integer.parseInt(request.getParameter("credit")));						
		} else {
			request.setAttribute("error", "Pas assez de crédit !");
		}
		CategorieManager CategorieManager = new CategorieManager();			
		List<Categorie> listC = CategorieManager.selectionnerAllCategorie();
	
		ArticleManager ArticleManager = new ArticleManager();	
	    List<ArticleVendu> articles = ArticleManager.getArticleDAO();
	    
	    request.setAttribute("articles", articles);	
		request.setAttribute("listCategorie", listC);
		
		rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	}

}
