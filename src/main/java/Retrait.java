/**
 * La classe Retrait représente l'adresse où un utilisateur peut retirer un article vendu.
 * 
 * Elle contient les informations nécessaires pour permettre à l'utilisateur de récupérer l'article qu'il a acheté.
 * 
 * @author [Corentin CADU / Victor MARSAC]
 * @version 1.0
 */
public class Retrait {
	private String rue;
	private String codePostal;
	private String ville;
	private ArticleVendu article;
	
	/**
	 * Constructeur pour la classe Retrait.
	 * 
	 * @param rue le nom de la rue où l'utilisateur peut récupérer l'article.
	 * @param codePostal le code postal de l'adresse de retrait.
	 * @param ville la ville où l'utilisateur peut récupérer l'article.
	 * @param article l'article vendu associé à l'adresse de retrait.
	 */
	public Retrait(String rue, String codePostal, String ville, ArticleVendu article) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}
	
	/**
	 * Renvoie le nom de la rue où l'utilisateur peut récupérer l'article.
	 * 
	 * @return le nom de la rue.
	 */
	public String getRue() {
		return rue;
	}
	
	/**
	 * Définit le nom de la rue où l'utilisateur peut récupérer l'article.
	 * 
	 * @param rue le nom de la rue.
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	/**
	 * Renvoie le code postal de l'adresse de retrait.
	 * 
	 * @return le code postal.
	 */
	public String getCodePostal() {
		return codePostal;
	}
	
	/**
	 * Définit le code postal de l'adresse de retrait.
	 * 
	 * @param codePostal le code postal.
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * Renvoie la ville où l'utilisateur peut récupérer l'article.
	 * 
	 * @return la ville.
	 */
	public String getVille() {
		return ville;
	}
	
	/**
	 * Définit la ville où l'utilisateur peut récupérer l'article.
	 * 
	 * @param ville la ville.
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * Renvoie l'article vendu associé à l'adresse de retrait.
	 * 
	 * @return l'article vendu.
	 */
	public ArticleVendu getArticle() {
		return article;
	}
	
	/**
	 * Définit l'article vendu associé à l'adresse de retrait.
	 * 
	 * @param article l'article vendu.
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
}
