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

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 672782266695834965L;
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

	public Utilisateur(int id, String nom, String prenom, String loginUser, String passwordUser, String email, String profil) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
		this.email = email;
		this.profil = profil;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.candidat == null) ? 0 : this.candidat.hashCode());
		result = (prime * result) + ((this.email == null) ? 0 : this.email.hashCode());
		result = (prime * result) + this.id;
		result = (prime * result) + ((this.loginUser == null) ? 0 : this.loginUser.hashCode());
		result = (prime * result) + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = (prime * result) + ((this.passwordUser == null) ? 0 : this.passwordUser.hashCode());
		result = (prime * result) + ((this.prenom == null) ? 0 : this.prenom.hashCode());
		result = (prime * result) + ((this.profil == null) ? 0 : this.profil.hashCode());
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
		final Utilisateur other = (Utilisateur) obj;
		if (this.candidat == null) {
			if (other.candidat != null) {
				return false;
			}
		} else if (!this.candidat.equals(other.candidat)) {
			return false;
		}
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
		if (this.loginUser == null) {
			if (other.loginUser != null) {
				return false;
			}
		} else if (!this.loginUser.equals(other.loginUser)) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.passwordUser == null) {
			if (other.passwordUser != null) {
				return false;
			}
		} else if (!this.passwordUser.equals(other.passwordUser)) {
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
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(this.id);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", prenom=");
		builder.append(this.prenom);
		builder.append(", loginUser=");
		builder.append(this.loginUser);
		builder.append(", passwordUser=");
		builder.append(this.passwordUser);
		builder.append(", email=");
		builder.append(this.email);
		builder.append(", profil=");
		builder.append(this.profil);
		builder.append(", candidat=");
		builder.append(this.candidat);
		builder.append("]");
		return builder.toString();
	}

}
