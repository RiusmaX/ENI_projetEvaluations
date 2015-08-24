package fr.eni_ecole.entities;

import java.util.HashSet;
import java.util.Set;
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

	private int id;
	private Candidat candidat;
	private String typeResultat;
	private int nbQuestionsTotal;
	private int nbQuestionsCorrectes;
	private int pourcentageBonnesReponses;
	private int temps;
	private Integer nbIncidents;
	private Set resultatSections = new HashSet(0);

	public Resultat() {
	}

	public Resultat(int id, Candidat candidat, String typeResultat,
			int nbQuestionsTotal, int nbQuestionsCorrectes,
			int pourcentageBonnesReponses, int temps) {
		this.id = id;
		this.candidat = candidat;
		this.typeResultat = typeResultat;
		this.nbQuestionsTotal = nbQuestionsTotal;
		this.nbQuestionsCorrectes = nbQuestionsCorrectes;
		this.pourcentageBonnesReponses = pourcentageBonnesReponses;
		this.temps = temps;
	}

	public Resultat(int id, Candidat candidat, String typeResultat,
			int nbQuestionsTotal, int nbQuestionsCorrectes,
			int pourcentageBonnesReponses, int temps, Integer nbIncidents,
			Set resultatSections) {
		this.id = id;
		this.candidat = candidat;
		this.typeResultat = typeResultat;
		this.nbQuestionsTotal = nbQuestionsTotal;
		this.nbQuestionsCorrectes = nbQuestionsCorrectes;
		this.pourcentageBonnesReponses = pourcentageBonnesReponses;
		this.temps = temps;
		this.nbIncidents = nbIncidents;
		this.resultatSections = resultatSections;
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
	public Set getResultatSections() {
		return this.resultatSections;
	}

	public void setResultatSections(Set resultatSections) {
		this.resultatSections = resultatSections;
	}

}
