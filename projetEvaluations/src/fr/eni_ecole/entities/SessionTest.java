package fr.eni_ecole.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6066392685206840446L;
	private int id;
	private Test test;
	private Date dateDebut;
	private Date dateFin;
	private boolean isArchive;
	private List<Candidat> candidats = new ArrayList<Candidat>(0);

	public SessionTest() {
	}

	public SessionTest(int id, Test test, Date dateDebut, Date dateFin, boolean isArchive) {
		this.id = id;
		this.test = test;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.isArchive = isArchive;
	}

	public SessionTest(int id, Test test, Date dateDebut, Date dateFin, boolean isArchive, List<Candidat> candidats) {
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
	public List<Candidat> getCandidats() {
		return this.candidats;
	}

	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.candidats == null) ? 0 : this.candidats.hashCode());
		result = (prime * result) + ((this.dateDebut == null) ? 0 : this.dateDebut.hashCode());
		result = (prime * result) + ((this.dateFin == null) ? 0 : this.dateFin.hashCode());
		result = (prime * result) + this.id;
		result = (prime * result) + (this.isArchive ? 1231 : 1237);
		result = (prime * result) + ((this.test == null) ? 0 : this.test.hashCode());
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
		final SessionTest other = (SessionTest) obj;
		if (this.candidats == null) {
			if (other.candidats != null) {
				return false;
			}
		} else if (!this.candidats.equals(other.candidats)) {
			return false;
		}
		if (this.dateDebut == null) {
			if (other.dateDebut != null) {
				return false;
			}
		} else if (!this.dateDebut.equals(other.dateDebut)) {
			return false;
		}
		if (this.dateFin == null) {
			if (other.dateFin != null) {
				return false;
			}
		} else if (!this.dateFin.equals(other.dateFin)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.isArchive != other.isArchive) {
			return false;
		}
		if (this.test == null) {
			if (other.test != null) {
				return false;
			}
		} else if (!this.test.equals(other.test)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("SessionTest [id=");
		builder.append(this.id);
		builder.append(", test=");
		builder.append(this.test);
		builder.append(", dateDebut=");
		builder.append(this.dateDebut);
		builder.append(", dateFin=");
		builder.append(this.dateFin);
		builder.append(", isArchive=");
		builder.append(this.isArchive);
		builder.append(", candidats=");
		builder.append(this.candidats);
		builder.append("]");
		return builder.toString();
	}

}
