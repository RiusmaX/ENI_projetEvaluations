package fr.eni_ecole.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Resultat
 */
@Entity
@Table(name = "RESULTAT", catalog = "projet")
public class Resultat implements java.io.Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8323699966013052969L;
	private int id;
	private Candidat candidat;
	private String typeResultat;
	private int nbQuestionsTotal;
	private int nbQuestionsCorrectes;
	private int pourcentageBonnesReponses;
	private int temps;
	private Integer nbIncidents;
	private List<ResultatSection> resultatSections = new ArrayList<ResultatSection>(0);

	public Resultat() {
	}

	public Resultat(int id, Candidat candidat, String typeResultat, int nbQuestionsTotal, int nbQuestionsCorrectes, int pourcentageBonnesReponses,
			int temps) {
		this.id = id;
		this.candidat = candidat;
		this.typeResultat = typeResultat;
		this.nbQuestionsTotal = nbQuestionsTotal;
		this.nbQuestionsCorrectes = nbQuestionsCorrectes;
		this.pourcentageBonnesReponses = pourcentageBonnesReponses;
		this.temps = temps;
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
	@JoinColumn(name = "CANDIDAT_id", nullable = false)
	public Candidat getCandidat() {
		return this.candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	@Column(name = "type_resultat", nullable = false)
	public String getTypeResultat() {
		return this.typeResultat;
	}

	public void setTypeResultat(String typeResultat) {
		this.typeResultat = typeResultat;
	}

	@Column(name = "nb_questions_total", nullable = false)
	public int getNbQuestionsTotal() {
		return this.nbQuestionsTotal;
	}

	public void setNbQuestionsTotal(int nbQuestionsTotal) {
		this.nbQuestionsTotal = nbQuestionsTotal;
	}

	@Column(name = "nb_questions_correctes", nullable = false)
	public int getNbQuestionsCorrectes() {
		return this.nbQuestionsCorrectes;
	}

	public void setNbQuestionsCorrectes(int nbQuestionsCorrectes) {
		this.nbQuestionsCorrectes = nbQuestionsCorrectes;
	}

	@Column(name = "pourcentage_bonnes_reponses", nullable = false)
	public int getPourcentageBonnesReponses() {
		return this.pourcentageBonnesReponses;
	}

	public void setPourcentageBonnesReponses(int pourcentageBonnesReponses) {
		this.pourcentageBonnesReponses = pourcentageBonnesReponses;
	}

	@Column(name = "temps", nullable = false)
	public int getTemps() {
		return this.temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	@Column(name = "nb_incidents")
	public Integer getNbIncidents() {
		return this.nbIncidents;
	}

	public void setNbIncidents(Integer nbIncidents) {
		this.nbIncidents = nbIncidents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resultat")
	public List<ResultatSection> getResultatSections() {
		return this.resultatSections;
	}

	public void setResultatSections(List<ResultatSection> resultatSections) {
		this.resultatSections = resultatSections;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.candidat == null) ? 0 : this.candidat.hashCode());
		result = (prime * result) + this.id;
		result = (prime * result) + ((this.nbIncidents == null) ? 0 : this.nbIncidents.hashCode());
		result = (prime * result) + this.nbQuestionsCorrectes;
		result = (prime * result) + this.nbQuestionsTotal;
		result = (prime * result) + this.pourcentageBonnesReponses;
		result = (prime * result) + ((this.resultatSections == null) ? 0 : this.resultatSections.hashCode());
		result = (prime * result) + this.temps;
		result = (prime * result) + ((this.typeResultat == null) ? 0 : this.typeResultat.hashCode());
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
		final Resultat other = (Resultat) obj;
		if (this.candidat == null) {
			if (other.candidat != null) {
				return false;
			}
		} else if (!this.candidat.equals(other.candidat)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.nbIncidents == null) {
			if (other.nbIncidents != null) {
				return false;
			}
		} else if (!this.nbIncidents.equals(other.nbIncidents)) {
			return false;
		}
		if (this.nbQuestionsCorrectes != other.nbQuestionsCorrectes) {
			return false;
		}
		if (this.nbQuestionsTotal != other.nbQuestionsTotal) {
			return false;
		}
		if (this.pourcentageBonnesReponses != other.pourcentageBonnesReponses) {
			return false;
		}
		if (this.resultatSections == null) {
			if (other.resultatSections != null) {
				return false;
			}
		} else if (!this.resultatSections.equals(other.resultatSections)) {
			return false;
		}
		if (this.temps != other.temps) {
			return false;
		}
		if (this.typeResultat == null) {
			if (other.typeResultat != null) {
				return false;
			}
		} else if (!this.typeResultat.equals(other.typeResultat)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Resultat [id=");
		builder.append(this.id);
		builder.append(", candidat=");
		builder.append(this.candidat);
		builder.append(", typeResultat=");
		builder.append(this.typeResultat);
		builder.append(", nbQuestionsTotal=");
		builder.append(this.nbQuestionsTotal);
		builder.append(", nbQuestionsCorrectes=");
		builder.append(this.nbQuestionsCorrectes);
		builder.append(", pourcentageBonnesReponses=");
		builder.append(this.pourcentageBonnesReponses);
		builder.append(", temps=");
		builder.append(this.temps);
		builder.append(", nbIncidents=");
		builder.append(this.nbIncidents);
		builder.append(", resultatSections=");
		builder.append(this.resultatSections);
		builder.append("]");
		return builder.toString();

	}

}
