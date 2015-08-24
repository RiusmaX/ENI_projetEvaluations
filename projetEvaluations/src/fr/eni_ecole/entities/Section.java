package fr.eni_ecole.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Section
 */
@Entity
@Table(name = "SECTION", catalog = "projet")
public class Section implements java.io.Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 2998266884806289508L;
	private int id;
	private Theme theme;
	private String nom;
	private int nbQuestions;
	private boolean isArchive;
	private List<ResultatSection> resultatSections = new ArrayList<ResultatSection>(0);
	private List<Test> tests = new ArrayList<Test>(0);

	public Section() {
	}

	public Section(int id, Theme theme, String nom, int nbQuestions, boolean isArchive) {
		this.id = id;
		this.theme = theme;
		this.nom = nom;
		this.nbQuestions = nbQuestions;
		this.isArchive = isArchive;
	}

	public Section(int id, Theme theme, String nom, int nbQuestions, boolean isArchive, List<ResultatSection> resultatSections, List<Test> tests) {
		this.id = id;
		this.theme = theme;
		this.nom = nom;
		this.nbQuestions = nbQuestions;
		this.isArchive = isArchive;
		this.resultatSections = resultatSections;
		this.tests = tests;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEME_id", nullable = false)
	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "nb_questions", nullable = false)
	public int getNbQuestions() {
		return this.nbQuestions;
	}

	public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}

	@Column(name = "isArchive", nullable = false)
	public boolean isIsArchive() {
		return this.isArchive;
	}

	public void setIsArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
	public List<ResultatSection> getResultatSections() {
		return this.resultatSections;
	}

	public void setResultatSections(List<ResultatSection> resultatSections) {
		this.resultatSections = resultatSections;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ASSOCIATION_TEST_SECTION", catalog = "projet", joinColumns = { @JoinColumn(name = "SECTION_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "TEST_id", nullable = false, updatable = false) })
	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
		result = (prime * result) + (this.isArchive ? 1231 : 1237);
		result = (prime * result) + this.nbQuestions;
		result = (prime * result) + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = (prime * result) + ((this.resultatSections == null) ? 0 : this.resultatSections.hashCode());
		result = (prime * result) + ((this.tests == null) ? 0 : this.tests.hashCode());
		result = (prime * result) + ((this.theme == null) ? 0 : this.theme.hashCode());
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
		final Section other = (Section) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.isArchive != other.isArchive) {
			return false;
		}
		if (this.nbQuestions != other.nbQuestions) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.resultatSections == null) {
			if (other.resultatSections != null) {
				return false;
			}
		} else if (!this.resultatSections.equals(other.resultatSections)) {
			return false;
		}
		if (this.tests == null) {
			if (other.tests != null) {
				return false;
			}
		} else if (!this.tests.equals(other.tests)) {
			return false;
		}
		if (this.theme == null) {
			if (other.theme != null) {
				return false;
			}
		} else if (!this.theme.equals(other.theme)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Section [id=");
		builder.append(this.id);
		builder.append(", theme=");
		builder.append(this.theme);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", nbQuestions=");
		builder.append(this.nbQuestions);
		builder.append(", isArchive=");
		builder.append(this.isArchive);
		builder.append(", resultatSections=");
		builder.append(this.resultatSections);
		builder.append(", tests=");
		builder.append(this.tests);
		builder.append("]");
		return builder.toString();
	}

}
