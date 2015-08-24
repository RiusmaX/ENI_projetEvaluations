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

	private int id;
	private Resultat resultat;
	private Section section;
	private int nbReponsesCorrectes;
	private int nbReponsesTotal;
	private int pourcentageBonnesReponses;

	public ResultatSection() {
	}

	public ResultatSection(int id, Resultat resultat, Section section,
			int nbReponsesCorrectes, int nbReponsesTotal,
			int pourcentageBonnesReponses) {
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

}
