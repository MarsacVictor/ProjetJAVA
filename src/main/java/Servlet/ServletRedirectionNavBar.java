package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
						"/DirectionDeconnexion"
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
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response); 
	     }
		 else if(request.getServletPath().equals("/DirectionMonProfil")){
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
	    	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
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
