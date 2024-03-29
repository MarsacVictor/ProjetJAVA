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
import Class.Utilisateur;
import Manager.ArticleManager;
import Manager.CategorieManager;
import Manager.UtilisateurManager;

/**
 * Servlet implementation class ServletModificationMonProfil
 */
@WebServlet(
		urlPatterns= {
						"/servletModificationProfil"
		})
public class ServletModificationMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificationMonProfil() {
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
	    CategorieManager CategorieManager = new CategorieManager();          
	    List<Categorie> listC = CategorieManager.selectionnerAllCategorie();
	    ArticleManager ArticleManager = new ArticleManager();	
	    List<ArticleVendu> articles = ArticleManager.getArticleDAO();
	    
	    request.setAttribute("articles", articles);	
	    request.setAttribute("listCategorie", listC);

	    RequestDispatcher rd = null;
	    HttpSession session = request.getSession();

	    String realPseudo = (String)session.getAttribute("identifiant");

	    String pseudo = request.getParameter("pseudo");
	    String prenom = request.getParameter("prenom");
	    String email = request.getParameter("email");
	    String telephone = request.getParameter("telephone");
	    String rue = request.getParameter("rue");
	    String code_postal = request.getParameter("code_postal");
	    String ville = request.getParameter("ville");
	    String mdp = request.getParameter("mot_de_passe");
	    String password = request.getParameter("new_mot_de_passe");
	    String confirmation = request.getParameter("confirmation");
	   
	    String hashedPassword = null;
		try {
			password = hashPassword(password);
			mdp = hashPassword(mdp);
			confirmation = hashPassword(confirmation);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    UtilisateurManager utilisateurManager = new UtilisateurManager();
	    if(utilisateurManager.ConnexionUtilisateur(realPseudo, mdp)) {
	        Utilisateur u = utilisateurManager.selectionnerUtilisateur(realPseudo);
	        if(password.equals(confirmation)) {
	            utilisateurManager.modifierMonProfil(u.getPseudo(), u.getEmail(), pseudo, prenom, email, telephone,rue,code_postal,ville,password );
	            rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
	        } else {
	        	request.setAttribute("pseudo", pseudo);;
				request.setAttribute("prenom", prenom);
				request.setAttribute("email", email);
				request.setAttribute("telephone", telephone);
				request.setAttribute("code_postal", code_postal);
				request.setAttribute("rue", rue);
				request.setAttribute("ville", ville);
				request.setAttribute("credit", request.getParameter("credit"));
	        	request.setAttribute("error2", "Les deux mots de passe sont différents !");
	            rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
	        }

	    } else {
		    	request.setAttribute("pseudo", pseudo);;
				request.setAttribute("prenom", prenom);
				request.setAttribute("email", email);
				request.setAttribute("telephone", telephone);
				request.setAttribute("code_postal", code_postal);
				request.setAttribute("rue", rue);
				request.setAttribute("ville", ville);
				request.setAttribute("credit", request.getParameter("credit"));
	    		request.setAttribute("error2", "Mauvais mot de passe !");
	            rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
	    }
	    rd.forward(request, response);

	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(password.getBytes());
	    byte[] bytes = md.digest();
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++)
	    {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	}


}
