package fr.eni_ecole.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import fr.eni.entities.Utilisateur;

/**
 * Candidat
 */
@Entity
/* Table CANDIDAT - BDD (catalog) projet */
@Table(name = "CANDIDAT", catalog = "projet")
public class Candidat implements java.io.Serializable {

	private int id;
	private Utilisateur utilisateur;
	private String nom;
	private String prenom;
	private String loginCandidat;
	private String passwordCandidat;
	private String email;
	private String profil;
	private Set sessionTests = new HashSet(0);
	//Set : un candidat peut avoir plusieurs résultats
	private Set resultats = new HashSet(0);

	public Candidat() {
	}

	public Candidat(Utilisateur utilisateur, String nom, String prenom,
			String loginCandidat, String passwordCandidat, String email,
			String profil) {
		this.utilisateur = utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.loginCandidat = loginCandidat;
		this.passwordCandidat = passwordCandidat;
		this.email = email;
		this.profil = profil;
	}

	public Candidat(Utilisateur utilisateur, String nom, String prenom,
			String loginCandidat, String passwordCandidat, String email,
			String profil, Set sessionTests, Set resultats) {
		this.utilisateur = utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.loginCandidat = loginCandidat;
		this.passwordCandidat = passwordCandidat;
		this.email = email;
		this.profil = profil;
		this.sessionTests = sessionTests;
		this.resultats = resultats;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "utilisateur"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "login_candidat", nullable = false)
	public String getLoginCandidat() {
		return this.loginCandidat;
	}

	public void setLoginCandidat(String loginCandidat) {
		this.loginCandidat = loginCandidat;
	}

	@Column(name = "password_candidat", nullable = false)
	public String getPasswordCandidat() {
		return this.passwordCandidat;
	}

	public void setPasswordCandidat(String passwordCandidat) {
		this.passwordCandidat = passwordCandidat;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "profil", nullable = false)
	public String getProfil() {
		return this.profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ASSOCIATION_CANDIDAT_SESSION", catalog = "projet", joinColumns = { @JoinColumn(name = "CANDIDAT_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SESSION_id", nullable = false, updatable = false) })
	public Set getSessionTests() {
		return this.sessionTests;
	}

	public void setSessionTests(Set sessionTests) {
		this.sessionTests = sessionTests;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidat")
	public Set getResultats() {
		return this.resultats;
	}

	public void setResultats(Set resultats) {
		this.resultats = resultats;
	}

}
