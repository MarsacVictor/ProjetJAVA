/**
 * La classe Utilisateur représente un utilisateur dans le système.
 */
public class Utilisateur {

    /**
     * Le numéro d'identification de l'utilisateur.
     */
    private int no_utilisateur;

    /**
     * Le pseudo de l'utilisateur.
     */
    private String pseudo;

    /**
     * Le nom de l'utilisateur.
     */
    private String nom;

    /**
     * Le prénom de l'utilisateur.
     */
    private String prenom;

    /**
     * L'adresse email de l'utilisateur.
     */
    private String email;

    /**
     * Le numéro de téléphone de l'utilisateur.
     */
    private String telephone;

    /**
     * La rue de l'utilisateur.
     */
    private String rue;

    /**
     * Le code postal de l'utilisateur.
     */
    private String code_postal;

    /**
     * La ville de l'utilisateur.
     */
    private String ville;

    /**
     * Le mot de passe de l'utilisateur.
     */
    private String mot_de_passe;

    /**
     * Le crédit de l'utilisateur.
     */
    private String credit;

    /**
     * Indique si l'utilisateur est un administrateur ou non.
     */
    private char administrateur;
	
	
	
	public Utilisateur() {
		super();
	}


/**
 * Constructeur de la classe Utilisateur.
 * 
 * @param pseudo          Le pseudo de l'utilisateur.
 * @param nom             Le nom de l'utilisateur.
 * @param prenom          Le prénom de l'utilisateur.
 * @param email           L'adresse email de l'utilisateur.
 * @param telephone       Le numéro de téléphone de l'utilisateur.
 * @param rue             La rue de l'utilisateur.
 * @param code_postal     Le code postal de l'utilisateur.
 * @param ville           La ville de l'utilisateur.
 * @param mot_de_passe    Le mot de passe de l'utilisateur.
 * @param credit          Le crédit de l'utilisateur.
 * @param administrateur  Indique si l'utilisateur est un administrateur ou non.
 */
	public Utilisateur( String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, String credit, char administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}



	public int getNo_utilisateur() {
		return no_utilisateur;
	}



	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}



	public String getPseudo() {
		return pseudo;
	}



	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getRue() {
		return rue;
	}



	public void setRue(String rue) {
		this.rue = rue;
	}



	public String getCode_postal() {
		return code_postal;
	}



	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getMot_de_passe() {
		return mot_de_passe;
	}



	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}



	public String getCredit() {
		return credit;
	}



	public void setCredit(String credit) {
		this.credit = credit;
	}



	public char getAdministrateur() {
		return administrateur;
	}



	public void setAdministrateur(char administrateur) {
		this.administrateur = administrateur;
	}
	
	
	
}
