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
 * Question
 */
@Entity
@Table(name = "QUESTION", catalog = "projet")
public class Question implements java.io.Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -2826475711445018272L;
	private int id;
	private Theme theme;
	private String enonce;
	private String type;
	private boolean isArchive;
	private String lienImage;
	private List<Reponse> reponses = new ArrayList<Reponse>(0);

	public Question() {
	}

	public Question(int id, Theme theme, String enonce, String type, boolean isArchive) {
		this.id = id;
		this.theme = theme;
		this.enonce = enonce;
		this.type = type;
		this.isArchive = isArchive;
	}

	public Question(int id, Theme theme, String enonce, String type, boolean isArchive, String lienImage, List<Reponse> reponses) {
		this.id = id;
		this.theme = theme;
		this.enonce = enonce;
		this.type = type;
		this.isArchive = isArchive;
		this.lienImage = lienImage;
		this.reponses = reponses;
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
	@JoinColumn(name = "THEME_id", nullable = false)
	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Column(name = "enonce", nullable = false)
	public String getEnonce() {
		return this.enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "isArchive", nullable = false)
	public boolean isIsArchive() {
		return this.isArchive;
	}

	public void setIsArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	@Column(name = "lien_image")
	public String getLienImage() {
		return this.lienImage;
	}

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.enonce == null) ? 0 : this.enonce.hashCode());
		result = (prime * result) + this.id;
		result = (prime * result) + (this.isArchive ? 1231 : 1237);
		result = (prime * result) + ((this.lienImage == null) ? 0 : this.lienImage.hashCode());
		result = (prime * result) + ((this.reponses == null) ? 0 : this.reponses.hashCode());
		result = (prime * result) + ((this.theme == null) ? 0 : this.theme.hashCode());
		result = (prime * result) + ((this.type == null) ? 0 : this.type.hashCode());
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
		final Question other = (Question) obj;
		if (this.enonce == null) {
			if (other.enonce != null) {
				return false;
			}
		} else if (!this.enonce.equals(other.enonce)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.isArchive != other.isArchive) {
			return false;
		}
		if (this.lienImage == null) {
			if (other.lienImage != null) {
				return false;
			}
		} else if (!this.lienImage.equals(other.lienImage)) {
			return false;
		}
		if (this.reponses == null) {
			if (other.reponses != null) {
				return false;
			}
		} else if (!this.reponses.equals(other.reponses)) {
			return false;
		}
		if (this.theme == null) {
			if (other.theme != null) {
				return false;
			}
		} else if (!this.theme.equals(other.theme)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Question [id=");
		builder.append(this.id);
		builder.append(", theme=");
		builder.append(this.theme);
		builder.append(", enonce=");
		builder.append(this.enonce);
		builder.append(", type=");
		builder.append(this.type);
		builder.append(", isArchive=");
		builder.append(this.isArchive);
		builder.append(", lienImage=");
		builder.append(this.lienImage);
		builder.append(", reponses=");
		builder.append(this.reponses);
		builder.append("]");
		return builder.toString();
	}

}
