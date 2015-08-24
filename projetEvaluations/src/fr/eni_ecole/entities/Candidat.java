package fr.eni_ecole.entities;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1181460793921010112L;
	private int id;
	private Utilisateur utilisateur;
	private String nom;
	private String prenom;
	private String loginCandidat;
	private String passwordCandidat;
	private String email;
	private String profil;
	private List<SessionTest> sessionTests = new ArrayList<SessionTest>(0);
	// Set : un candidat peut avoir plusieurs r�sultats
	private List<Resultat> resultats = new ArrayList<Resultat>(0);

	public Candidat() {
	}

	public Candidat(Utilisateur utilisateur, String nom, String prenom, String loginCandidat, String passwordCandidat, String email, String profil) {
		this.utilisateur = utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.loginCandidat = loginCandidat;
		this.passwordCandidat = passwordCandidat;
		this.email = email;
		this.profil = profil;
	}

	public Candidat(Utilisateur utilisateur, String nom, String prenom, String loginCandidat, String passwordCandidat, String email, String profil,
			List<SessionTest> sessionTests, List<Resultat> resultats) {
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
	public List<SessionTest> getSessionTests() {
		return this.sessionTests;
	}

	public void setSessionTests(List<SessionTest> sessionTests) {
		this.sessionTests = sessionTests;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidat")
	public List<Resultat> getResultats() {
		return this.resultats;
	}

	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.email == null) ? 0 : this.email.hashCode());
		result = (prime * result) + this.id;
		result = (prime * result) + ((this.loginCandidat == null) ? 0 : this.loginCandidat.hashCode());
		result = (prime * result) + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = (prime * result) + ((this.passwordCandidat == null) ? 0 : this.passwordCandidat.hashCode());
		result = (prime * result) + ((this.prenom == null) ? 0 : this.prenom.hashCode());
		result = (prime * result) + ((this.profil == null) ? 0 : this.profil.hashCode());
		result = (prime * result) + ((this.resultats == null) ? 0 : this.resultats.hashCode());
		result = (prime * result) + ((this.sessionTests == null) ? 0 : this.sessionTests.hashCode());
		result = (prime * result) + ((this.utilisateur == null) ? 0 : this.utilisateur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Candidat other = (Candidat) obj;
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.loginCandidat == null) {
			if (other.loginCandidat != null) {
				return false;
			}
		} else if (!this.loginCandidat.equals(other.loginCandidat)) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.passwordCandidat == null) {
			if (other.passwordCandidat != null) {
				return false;
			}
		} else if (!this.passwordCandidat.equals(other.passwordCandidat)) {
			return false;
		}
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!this.prenom.equals(other.prenom)) {
			return false;
		}
		if (this.profil == null) {
			if (other.profil != null) {
				return false;
			}
		} else if (!this.profil.equals(other.profil)) {
			return false;
		}
		if (this.resultats == null) {
			if (other.resultats != null) {
				return false;
			}
		} else if (!this.resultats.equals(other.resultats)) {
			return false;
		}
		if (this.sessionTests == null) {
			if (other.sessionTests != null) {
				return false;
			}
		} else if (!this.sessionTests.equals(other.sessionTests)) {
			return false;
		}
		if (this.utilisateur == null) {
			if (other.utilisateur != null) {
				return false;
			}
		} else if (!this.utilisateur.equals(other.utilisateur)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Candidat [id=");
		builder.append(this.id);
		builder.append(", utilisateur=");
		builder.append(this.utilisateur);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", prenom=");
		builder.append(this.prenom);
		builder.append(", loginCandidat=");
		builder.append(this.loginCandidat);
		builder.append(", passwordCandidat=");
		builder.append(this.passwordCandidat);
		builder.append(", email=");
		builder.append(this.email);
		builder.append(", profil=");
		builder.append(this.profil);
		builder.append(", sessionTests=");
		builder.append(this.sessionTests);
		builder.append(", resultats=");
		builder.append(this.resultats);
		builder.append("]");
		return builder.toString();
	}

}
