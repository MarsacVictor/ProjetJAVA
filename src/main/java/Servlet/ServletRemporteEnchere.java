package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Class.ArticleVendu;
import Class.Utilisateur;
import Manager.*;

/**
 * Servlet implementation class ServletRemporteEnchere
 */
@WebServlet("/DirectionRemporteEnchere")
public class ServletRemporteEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemporteEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i;
		Utilisateur u = null;
		UtilisateurManager utilisateurManager= new UtilisateurManager();
		ArticleManager articleManager = new ArticleManager();
		EnchereManager enchereManager = new EnchereManager();
		ArticleVendu av = articleManager.selectArticleID(Integer.parseInt(request.getQueryString()));
		av.setNoArticle(Integer.parseInt(request.getQueryString()));
		if(enchereManager.enchereArticle(Integer.parseInt(request.getQueryString()))) {
			articleManager.gagnerEnchere(av);
			i = enchereManager.enchereRemporte(av.getNoArticle());
			u = utilisateurManager.selectUtilisateurByID(i);
		}
		request.setAttribute("listCategorie", u);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/UtilisateurRemporterEncheres.jsp");
		rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
