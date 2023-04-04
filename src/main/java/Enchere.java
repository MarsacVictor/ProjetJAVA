import java.sql.Date;

public class Enchere {
	private Utilisateur utilisateur;
	private ArticleVendu article;
	private Date dateEnchere;
	private int MontantEnchere;
	
	public Enchere() {
		super();
	}
	public Enchere(Utilisateur utilisateur, ArticleVendu article, Date dateEnchere, int montantEnchere) {
		super();
		this.utilisateur = utilisateur;
		this.article = article;
		this.dateEnchere = dateEnchere;
		MontantEnchere = montantEnchere;
	}
	
	
}
