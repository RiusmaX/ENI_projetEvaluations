package fr.eni_ecole.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * ResultatSection
 */
@Entity
@Table(name = "RESULTAT_SECTION", catalog = "projet", uniqueConstraints = @UniqueConstraint(columnNames = "SECTION_id"))
public class ResultatSection implements java.io.Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 7675447236899288639L;
	private int id;
	private Resultat resultat;
	private Section section;
	private int nbReponsesCorrectes;
	private int nbReponsesTotal;
	private int pourcentageBonnesReponses;

	public ResultatSection() {
	}

	public ResultatSection(int id, Resultat resultat, Section section, int nbReponsesCorrectes, int nbReponsesTotal, int pourcentageBonnesReponses) {
		this.id = id;
		this.resultat = resultat;
		this.section = section;
		this.nbReponsesCorrectes = nbReponsesCorrectes;
		this.nbReponsesTotal = nbReponsesTotal;
		this.pourcentageBonnesReponses = pourcentageBonnesReponses;
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
	@JoinColumn(name = "RESULTAT_id", nullable = false)
	public Resultat getResultat() {
		return this.resultat;
	}

	public void setResultat(Resultat resultat) {
		this.resultat = resultat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECTION_id", unique = true, nullable = false)
	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Column(name = "nb_reponses_correctes", nullable = false)
	public int getNbReponsesCorrectes() {
		return this.nbReponsesCorrectes;
	}

	public void setNbReponsesCorrectes(int nbReponsesCorrectes) {
		this.nbReponsesCorrectes = nbReponsesCorrectes;
	}

	@Column(name = "nb_reponses_total", nullable = false)
	public int getNbReponsesTotal() {
		return this.nbReponsesTotal;
	}

	public void setNbReponsesTotal(int nbReponsesTotal) {
		this.nbReponsesTotal = nbReponsesTotal;
	}

	@Column(name = "pourcentage_bonnes_reponses", nullable = false)
	public int getPourcentageBonnesReponses() {
		return this.pourcentageBonnesReponses;
	}

	public void setPourcentageBonnesReponses(int pourcentageBonnesReponses) {
		this.pourcentageBonnesReponses = pourcentageBonnesReponses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
		result = (prime * result) + this.nbReponsesCorrectes;
		result = (prime * result) + this.nbReponsesTotal;
		result = (prime * result) + this.pourcentageBonnesReponses;
		result = (prime * result) + ((this.resultat == null) ? 0 : this.resultat.hashCode());
		result = (prime * result) + ((this.section == null) ? 0 : this.section.hashCode());
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
		final ResultatSection other = (ResultatSection) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.nbReponsesCorrectes != other.nbReponsesCorrectes) {
			return false;
		}
		if (this.nbReponsesTotal != other.nbReponsesTotal) {
			return false;
		}
		if (this.pourcentageBonnesReponses != other.pourcentageBonnesReponses) {
			return false;
		}
		if (this.resultat == null) {
			if (other.resultat != null) {
				return false;
			}
		} else if (!this.resultat.equals(other.resultat)) {
			return false;
		}
		if (this.section == null) {
			if (other.section != null) {
				return false;
			}
		} else if (!this.section.equals(other.section)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ResultatSection [id=");
		builder.append(this.id);
		builder.append(", resultat=");
		builder.append(this.resultat);
		builder.append(", section=");
		builder.append(this.section);
		builder.append(", nbReponsesCorrectes=");
		builder.append(this.nbReponsesCorrectes);
		builder.append(", nbReponsesTotal=");
		builder.append(this.nbReponsesTotal);
		builder.append(", pourcentageBonnesReponses=");
		builder.append(this.pourcentageBonnesReponses);
		builder.append("]");
		return builder.toString();
	}

}
