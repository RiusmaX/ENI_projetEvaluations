package fr.eni_ecole.entities;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * SessionTest
 */
@Entity
@Table(name = "SESSION_TEST", catalog = "projet")
public class SessionTest implements java.io.Serializable {

	private int id;
	private Test test;
	private Date dateDebut;
	private Date dateFin;
	private boolean isArchive;
	private Set candidats = new HashSet(0);

	public SessionTest() {
	}

	public SessionTest(int id, Test test, Date dateDebut, Date dateFin,
			boolean isArchive) {
		this.id = id;
		this.test = test;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.isArchive = isArchive;
	}

	public SessionTest(int id, Test test, Date dateDebut, Date dateFin,
			boolean isArchive, Set candidats) {
		this.id = id;
		this.test = test;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.isArchive = isArchive;
		this.candidats = candidats;
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
	@JoinColumn(name = "TEST_id", nullable = false)
	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_debut", nullable = false, length = 23)
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_fin", nullable = false, length = 23)
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Column(name = "isArchive", nullable = false)
	public boolean isIsArchive() {
		return this.isArchive;
	}

	public void setIsArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ASSOCIATION_CANDIDAT_SESSION", catalog = "projet", joinColumns = { @JoinColumn(name = "SESSION_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "CANDIDAT_id", nullable = false, updatable = false) })
	public Set getCandidats() {
		return this.candidats;
	}

	public void setCandidats(Set candidats) {
		this.candidats = candidats;
	}

}
