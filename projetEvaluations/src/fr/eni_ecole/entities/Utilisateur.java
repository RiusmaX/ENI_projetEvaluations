package fr.eni_ecole.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Utilisateur
 */
@Entity
@Table(name = "UTILISATEUR", catalog = "projet")
public class Utilisateur implements java.io.Serializable {

	private int id;
	private String nom;
	private String prenom;
	private String loginUser;
	private String passwordUser;
	private String email;
	private String profil;
	private Candidat candidat;

	public Utilisateur() {
	}

	public Utilisateur(int id, String nom, String prenom, String loginUser,
			String passwordUser, String email, String profil) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
		this.email = email;
		this.profil = profil;
	}

	public Utilisateur(int id, String nom, String prenom, String loginUser,
			String passwordUser, String email, String profil, Candidat candidat) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
		this.email = email;
		this.profil = profil;
		this.candidat = candidat;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Column(name = "login_user", nullable = false)
	public String getLoginUser() {
		return this.loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	@Column(name = "password_user", nullable = false)
	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Candidat getCandidat() {
		return this.candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

}
