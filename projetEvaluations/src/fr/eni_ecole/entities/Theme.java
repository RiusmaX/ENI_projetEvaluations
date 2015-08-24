package fr.eni_ecole.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Theme
 */
@Entity
@Table(name = "THEME", catalog = "projet")
public class Theme implements java.io.Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4252607876044025168L;
	private int id;
	private String nom;
	private boolean isArchive;
	private List<Section> sections = new ArrayList<Section>(0);
	private List<Question> questions = new ArrayList<Question>(0);

	public Theme() {
	}

	public Theme(int id, String nom, boolean isArchive) {
		this.id = id;
		this.nom = nom;
		this.isArchive = isArchive;
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

	@Column(name = "isArchive", nullable = false)
	public boolean isIsArchive() {
		return this.isArchive;
	}

	public void setIsArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theme")
	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theme")
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
		result = (prime * result) + (this.isArchive ? 1231 : 1237);
		result = (prime * result) + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = (prime * result) + ((this.questions == null) ? 0 : this.questions.hashCode());
		result = (prime * result) + ((this.sections == null) ? 0 : this.sections.hashCode());
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
		final Theme other = (Theme) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.isArchive != other.isArchive) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.questions == null) {
			if (other.questions != null) {
				return false;
			}
		} else if (!this.questions.equals(other.questions)) {
			return false;
		}
		if (this.sections == null) {
			if (other.sections != null) {
				return false;
			}
		} else if (!this.sections.equals(other.sections)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Theme [id=");
		builder.append(this.id);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", isArchive=");
		builder.append(this.isArchive);
		builder.append(", sections=");
		builder.append(this.sections);
		builder.append(", questions=");
		builder.append(this.questions);
		builder.append("]");
		return builder.toString();
	}

}
