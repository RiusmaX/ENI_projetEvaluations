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

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4644763386736739037L;
	private int id;
	private Question question;
	private boolean isBonneReponse;
	private String libelle;
	private boolean isArchive;

	public Reponse() {
	}

	public Reponse(int id, Question question, boolean isBonneReponse, String libelle, boolean isArchive) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
		result = (prime * result) + (this.isArchive ? 1231 : 1237);
		result = (prime * result) + (this.isBonneReponse ? 1231 : 1237);
		result = (prime * result) + ((this.libelle == null) ? 0 : this.libelle.hashCode());
		result = (prime * result) + ((this.question == null) ? 0 : this.question.hashCode());
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
		final Reponse other = (Reponse) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.isArchive != other.isArchive) {
			return false;
		}
		if (this.isBonneReponse != other.isBonneReponse) {
			return false;
		}
		if (this.libelle == null) {
			if (other.libelle != null) {
				return false;
			}
		} else if (!this.libelle.equals(other.libelle)) {
			return false;
		}
		if (this.question == null) {
			if (other.question != null) {
				return false;
			}
		} else if (!this.question.equals(other.question)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Reponse [id=");
		builder.append(this.id);
		builder.append(", question=");
		builder.append(this.question);
		builder.append(", isBonneReponse=");
		builder.append(this.isBonneReponse);
		builder.append(", libelle=");
		builder.append(this.libelle);
		builder.append(", isArchive=");
		builder.append(this.isArchive);
		builder.append("]");
		return builder.toString();

	}
}
