package Class;
/**
 * La classe Categorie représente une catégorie d'article vendu aux enchères.
 * 
 * @author [Corentin CADU / Victor MARSAC]
 * @version 1.0
 */
public class Categorie {
	private int noCategorie;
	private String libelle;
	
	/**
	 * Constructeur par défaut pour la classe Categorie.
	 */
	public Categorie() {
		super();
	}

	/**
	 * Constructeur pour la classe Categorie.
	 * 
	 * @param libelle le libellé de la catégorie.
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	
}
