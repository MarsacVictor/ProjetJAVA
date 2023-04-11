package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Class.Categorie;
import Class.Utilisateur;
import Manager.*;

/**
 * Servlet implementation class ServletNouvelleArticle
 */
@WebServlet("/servletNouvelleArticle")
public class ServletNouvelleArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNouvelleArticle() {
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
		UtilisateurManager utilisateurManager = new UtilisateurManager();			
		Utilisateur u = utilisateurManager.selectionnerUtilisateur((String)session.getAttribute("identifiant"));
		
		CategorieManager CategorieManager = new CategorieManager();			
		List<Categorie> listC = CategorieManager.selectionnerAllCategorie();
		request.setAttribute("listCategorie", listC);
				
		
		String nomArticle =request.getParameter("article");
		String description =request.getParameter("description");
		String categorie = request.getParameter("categorie");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println(request.getParameter("dateStart"));
		System.out.println(request.getParameter("dateEnd"));
		try {
			System.out.println(dateFormat.parse(request.getParameter("dateStart")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		int prix = Integer.parseInt(request.getParameter("prix"));
		RequestDispatcher rd = null;
								
		ArticleManager articleManager = new ArticleManager();
		try {
			articleManager.insertArticle(nomArticle, description, categorie, prix, dateFormat.parse(request.getParameter("dateStart")), dateFormat.parse(request.getParameter("dateEnd")), rue, code_postal, ville, u);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
		}
	}

