package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import Class.ArticleVendu;
import Class.Categorie;
import Manager.ArticleManager;
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
	    ArticleManager ArticleManager = new ArticleManager();	
	    List<ArticleVendu> articles = ArticleManager.getArticleDAO();
	    
	    request.setAttribute("articles", articles);	
	    request.setAttribute("listCategorie", listC);
	    
	    if(request.getServletPath().equals("/servletConn")) {
	        RequestDispatcher rd;
	        String identifiant="";
	        String mdp="";
	        
	        identifiant = request.getParameter("identifiant");
	        mdp = request.getParameter("motdepasse");
	        
	        UtilisateurManager utilisateurManager = new UtilisateurManager();
	        String hashedMdp = null;
	        try {
	            hashedMdp = Hachagemotdepasse(mdp);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        
	        if(utilisateurManager.ConnexionUtilisateur(identifiant, hashedMdp)) {
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
	
	private String Hachagemotdepasse(String mot_de_passe) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(mot_de_passe.getBytes());
	    byte[] bytes = md.digest();
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++)
	    {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	}

}