package Class;
import java.util.Date;
/**
 * La classe ArticleVendu représente un article vendu aux enchères.
 * 
 * @author [Corentin CADU / Victor MARSAC]
 * @version 1.0
 */
public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	
	/**
	 * Constructeur pour la classe ArticleVendu.
	 * 
	 * @param nomArticle le nom de l'article vendu.
	 * @param description la description de l'article vendu.
	 * @param dateDebutEncheres la date de début des enchères pour l'article.
	 * @param dateFinEncheres la date de fin des enchères pour l'article.
	 * @param prixInitial le prix initial de l'article vendu.
	 * @param prixVente le prix final de l'article vendu.
	 * @param utilisateur l'utilisateur ayant mis en vente l'article.
	 * @param categorie la catégorie de l'article vendu.
	 */
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * Constructeur par défaut pour la classe ArticleVendu.
	 */
	public ArticleVendu() {
		super();
	}
}
