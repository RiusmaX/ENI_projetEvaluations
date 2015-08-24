package fr.eni_ecole.entities;

import java.util.HashSet;
import java.util.Set;
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

	private int id;
	private String nom;
	private boolean isArchive;
	private Set sections = new HashSet(0);
	private Set questions = new HashSet(0);

	public Theme() {
	}

	public Theme(int id, String nom, boolean isArchive) {
		this.id = id;
		this.nom = nom;
		this.isArchive = isArchive;
	}

	public Theme(int id, String nom, boolean isArchive, Set sections,
			Set questions) {
		this.id = id;
		this.nom = nom;
		this.isArchive = isArchive;
		this.sections = sections;
		this.questions = questions;
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
	public Set getSections() {
		return this.sections;
	}

	public void setSections(Set sections) {
		this.sections = sections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theme")
	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}
