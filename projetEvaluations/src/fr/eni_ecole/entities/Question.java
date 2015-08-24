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
 * Question
 */
@Entity
@Table(name = "QUESTION", catalog = "projet")
public class Question implements java.io.Serializable {

	private int id;
	private Theme theme;
	private String enonce;
	private String type;
	private boolean isArchive;
	private String lienImage;
	private Set reponses = new HashSet(0);

	public Question() {
	}

	public Question(int id, Theme theme, String enonce, String type,
			boolean isArchive) {
		this.id = id;
		this.theme = theme;
		this.enonce = enonce;
		this.type = type;
		this.isArchive = isArchive;
	}

	public Question(int id, Theme theme, String enonce, String type,
			boolean isArchive, String lienImage, Set reponses) {
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
	public Set getReponses() {
		return this.reponses;
	}

	public void setReponses(Set reponses) {
		this.reponses = reponses;
	}

}
