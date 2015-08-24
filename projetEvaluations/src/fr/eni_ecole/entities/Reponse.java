package fr.eni_ecole.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Reponse
 */
@Entity
@Table(name = "REPONSE", catalog = "projet")
public class Reponse implements java.io.Serializable {

	private int id;
	private Question question;
	private boolean isBonneReponse;
	private String libelle;
	private boolean isArchive;

	public Reponse() {
	}

	public Reponse(int id, Question question, boolean isBonneReponse,
			String libelle, boolean isArchive) {
		this.id = id;
		this.question = question;
		this.isBonneReponse = isBonneReponse;
		this.libelle = libelle;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_id", nullable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "isBonneReponse", nullable = false)
	public boolean isIsBonneReponse() {
		return this.isBonneReponse;
	}

	public void setIsBonneReponse(boolean isBonneReponse) {
		this.isBonneReponse = isBonneReponse;
	}

	@Column(name = "libelle", nullable = false)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name = "isArchive", nullable = false)
	public boolean isIsArchive() {
		return this.isArchive;
	}

	public void setIsArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

}
