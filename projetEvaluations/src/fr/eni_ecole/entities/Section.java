package fr.eni_ecole.entities;

import java.util.HashSet;
import java.util.Set;
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

	private int id;
	private Theme theme;
	private String nom;
	private int nbQuestions;
	private boolean isArchive;
	private Set resultatSections = new HashSet(0);
	private Set tests = new HashSet(0);

	public Section() {
	}

	public Section(int id, Theme theme, String nom, int nbQuestions,
			boolean isArchive) {
		this.id = id;
		this.theme = theme;
		this.nom = nom;
		this.nbQuestions = nbQuestions;
		this.isArchive = isArchive;
	}

	public Section(int id, Theme theme, String nom, int nbQuestions,
			boolean isArchive, Set resultatSections, Set tests) {
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
	public Set getResultatSections() {
		return this.resultatSections;
	}

	public void setResultatSections(Set resultatSections) {
		this.resultatSections = resultatSections;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ASSOCIATION_TEST_SECTION", catalog = "projet", joinColumns = { @JoinColumn(name = "SECTION_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "TEST_id", nullable = false, updatable = false) })
	public Set getTests() {
		return this.tests;
	}

	public void setTests(Set tests) {
		this.tests = tests;
	}

}
