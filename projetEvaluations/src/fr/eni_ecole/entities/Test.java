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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Test
 */
@Entity
@Table(name = "TEST", catalog = "projet")
public class Test implements java.io.Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4189234859572723344L;
	private int id;
	private String nom;
	private int seuilEnCourAcquisition;
	private int seuilAcquis;
	private String nature;
	private int tempsMax;
	private boolean isArchive;
	private List<Section> sections = new ArrayList<Section>(0);
	private List<SessionTest> sessionTests = new ArrayList<SessionTest>(0);

	public Test() {
	}

	public Test(int id, String nom, int seuilEnCourAcquisition, int seuilAcquis, String nature, int tempsMax, boolean isArchive) {
		this.id = id;
		this.nom = nom;
		this.seuilEnCourAcquisition = seuilEnCourAcquisition;
		this.seuilAcquis = seuilAcquis;
		this.nature = nature;
		this.tempsMax = tempsMax;
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
	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
	public List<SessionTest> getSessionTests() {
		return this.sessionTests;
	}

	public void setSessionTests(List<SessionTest> sessionTests) {
		this.sessionTests = sessionTests;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
		result = (prime * result) + (this.isArchive ? 1231 : 1237);
		result = (prime * result) + ((this.nature == null) ? 0 : this.nature.hashCode());
		result = (prime * result) + ((this.nom == null) ? 0 : this.nom.hashCode());
		result = (prime * result) + ((this.sections == null) ? 0 : this.sections.hashCode());
		result = (prime * result) + ((this.sessionTests == null) ? 0 : this.sessionTests.hashCode());
		result = (prime * result) + this.seuilAcquis;
		result = (prime * result) + this.seuilEnCourAcquisition;
		result = (prime * result) + this.tempsMax;
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
		final Test other = (Test) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.isArchive != other.isArchive) {
			return false;
		}
		if (this.nature == null) {
			if (other.nature != null) {
				return false;
			}
		} else if (!this.nature.equals(other.nature)) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.sections == null) {
			if (other.sections != null) {
				return false;
			}
		} else if (!this.sections.equals(other.sections)) {
			return false;
		}
		if (this.sessionTests == null) {
			if (other.sessionTests != null) {
				return false;
			}
		} else if (!this.sessionTests.equals(other.sessionTests)) {
			return false;
		}
		if (this.seuilAcquis != other.seuilAcquis) {
			return false;
		}
		if (this.seuilEnCourAcquisition != other.seuilEnCourAcquisition) {
			return false;
		}
		if (this.tempsMax != other.tempsMax) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Test [id=");
		builder.append(this.id);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", seuilEnCourAcquisition=");
		builder.append(this.seuilEnCourAcquisition);
		builder.append(", seuilAcquis=");
		builder.append(this.seuilAcquis);
		builder.append(", nature=");
		builder.append(this.nature);
		builder.append(", tempsMax=");
		builder.append(this.tempsMax);
		builder.append(", isArchive=");
		builder.append(this.isArchive);
		builder.append(", sections=");
		builder.append(this.sections);
		builder.append(", sessionTests=");
		builder.append(this.sessionTests);
		builder.append("]");
		return builder.toString();
	}

}
