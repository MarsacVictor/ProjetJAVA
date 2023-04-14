package Servlet;
import Manager.*;
import Class.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.io.IOException;

/**
 * Servlet implementation class ServletRedirectionEncheres
 */
@WebServlet(
		urlPatterns= {
						"/DirectionDetailEncheres",
		})
public class ServletRedirectionEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRedirectionEncheres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean encheri = true;
		Utilisateur u;
		 if(request.getServletPath().equals("/DirectionDetailEncheres")) {
			 	
			 	EnchereManager enchereManager = new EnchereManager();
			 	UtilisateurManager utilisateurManager = new UtilisateurManager();
			 	ArticleManager articleManager = new ArticleManager();
			 	Date date = new Date();
			 	ArticleVendu av = articleManager.selectArticleID(Integer.parseInt(request.getQueryString()));
			 	Retrait r = articleManager.selectRetraitID(Integer.parseInt(request.getQueryString()));
			 	HttpSession session = request.getSession();
			 	session.setAttribute("articleEnchere", av);	
			 	session.setAttribute("retraitEnchere", r);
			 	if(session.getAttribute("identifiant").equals(av.getUtilisateur().getPseudo())) {
			 		encheri = false;
			 	}
			 	u = utilisateurManager.selectionnerUtilisateur((String)session.getAttribute("identifiant"));
			 	if ( enchereManager.utilisateurDejaEncheriMax(u.getNo_utilisateur(), av.getNoArticle())) {
			 		encheri = false;
			 	}
			 	if(av.getDateDebutEncheres().compareTo(date) > 0) {
			 		encheri = false;
			 	}
			 	request.setAttribute("encheri", encheri);
	        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/detailVenteEncheres.jsp");
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
