package Class;
import java.sql.Date;

/**
 * La classe Enchere représente une enchère pour un article vendu aux enchères.
 * 
 * @author [Corentin CADU / Vicor MARSAC]
 * @version 1.0
 */
public class Enchere {
	private Utilisateur utilisateur;
	private ArticleVendu article;
	private Date dateEnchere;
	private int MontantEnchere;
	
	/**
	 * Constructeur par défaut pour la classe Enchere.
	 */
	public Enchere() {
		super();
	}
	
	/**
	 * Constructeur pour la classe Enchere.
	 * 
	 * @param utilisateur l'utilisateur ayant fait l'enchère.
	 * @param article l'article pour lequel l'enchère a été faite.
	 * @param dateEnchere la date à laquelle l'enchère a été faite.
	 * @param montantEnchere le montant de l'enchère.
	 */
	public Enchere(Utilisateur utilisateur, ArticleVendu article, Date dateEnchere, int montantEnchere) {
		super();
		this.utilisateur = utilisateur;
		this.article = article;
		this.dateEnchere = dateEnchere;
		MontantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public int getMontantEnchere() {
		return MontantEnchere;
	}
	
	
}
