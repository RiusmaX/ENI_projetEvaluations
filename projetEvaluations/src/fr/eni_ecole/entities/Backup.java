package fr.eni_ecole.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Backup
 */
@Entity
@Table(name = "_BACKUP", catalog = "projet")
public class Backup implements java.io.Serializable {

	private int id;
	private byte[] serialisable;

	public Backup() {
	}

	public Backup(int id, byte[] serialisable) {
		this.id = id;
		this.serialisable = serialisable;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "serialisable", nullable = false)
	public byte[] getSerialisable() {
		return this.serialisable;
	}

	public void setSerialisable(byte[] serialisable) {
		this.serialisable = serialisable;
	}

}
