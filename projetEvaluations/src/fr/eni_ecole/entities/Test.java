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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Test
 */
@Entity
@Table(name = "TEST", catalog = "projet")
public class Test implements java.io.Serializable {

	private int id;
	private String nom;
	private int seuilEnCourAcquisition;
	private int seuilAcquis;
	private String nature;
	private int tempsMax;
	private boolean isArchive;
	private Set sections = new HashSet(0);
	private Set sessionTests = new HashSet(0);

	public Test() {
	}

	public Test(int id, String nom, int seuilEnCourAcquisition,
			int seuilAcquis, String nature, int tempsMax, boolean isArchive) {
		this.id = id;
		this.nom = nom;
		this.seuilEnCourAcquisition = seuilEnCourAcquisition;
		this.seuilAcquis = seuilAcquis;
		this.nature = nature;
		this.tempsMax = tempsMax;
		this.isArchive = isArchive;
	}

	public Test(int id, String nom, int seuilEnCourAcquisition,
			int seuilAcquis, String nature, int tempsMax, boolean isArchive,
			Set sections, Set sessionTests) {
		this.id = id;
		this.nom = nom;
		this.seuilEnCourAcquisition = seuilEnCourAcquisition;
		this.seuilAcquis = seuilAcquis;
		this.nature = nature;
		this.tempsMax = tempsMax;
		this.isArchive = isArchive;
		this.sections = sections;
		this.sessionTests = sessionTests;
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

	@Column(name = "seuil_en_cour_acquisition", nullable = false)
	public int getSeuilEnCourAcquisition() {
		return this.seuilEnCourAcquisition;
	}

	public void setSeuilEnCourAcquisition(int seuilEnCourAcquisition) {
		this.seuilEnCourAcquisition = seuilEnCourAcquisition;
	}

	@Column(name = "seuil_acquis", nullable = false)
	public int getSeuilAcquis() {
		return this.seuilAcquis;
	}

	public void setSeuilAcquis(int seuilAcquis) {
		this.seuilAcquis = seuilAcquis;
	}

	@Column(name = "nature", nullable = false)
	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@Column(name = "temps_max", nullable = false)
	public int getTempsMax() {
		return this.tempsMax;
	}

	public void setTempsMax(int tempsMax) {
		this.tempsMax = tempsMax;
	}

	@Column(name = "isArchive", nullable = false)
	public boolean isIsArchive() {
		return this.isArchive;
	}

	public void setIsArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ASSOCIATION_TEST_SECTION", catalog = "projet", joinColumns = { @JoinColumn(name = "TEST_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SECTION_id", nullable = false, updatable = false) })
	public Set getSections() {
		return this.sections;
	}

	public void setSections(Set sections) {
		this.sections = sections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
	public Set getSessionTests() {
		return this.sessionTests;
	}

	public void setSessionTests(Set sessionTests) {
		this.sessionTests = sessionTests;
	}

}
