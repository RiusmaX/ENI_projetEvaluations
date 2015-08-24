package fr.eni_ecole.entities;

import java.util.Arrays;

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

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4476507576796409028L;
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

	@Column(name = "serialisable", nullable = false)
	public byte[] getSerialisable() {
		return this.serialisable;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSerialisable(byte[] serialisable) {
		this.serialisable = serialisable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
		result = (prime * result) + Arrays.hashCode(this.serialisable);
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
		final Backup other = (Backup) obj;
		if (this.id != other.id) {
			return false;
		}
		if (!Arrays.equals(this.serialisable, other.serialisable)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Backup [id=");
		builder.append(this.id);
		builder.append(", serialisable=");
		builder.append(Arrays.toString(this.serialisable));
		builder.append("]");
		return builder.toString();

	}
}
