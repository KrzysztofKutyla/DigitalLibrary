package com.dl.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @TableGenerator(name = "Auth_Gen", table = "ID_GEN", pkColumnName =
	// "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Addr_Gen",
	// initialValue = 100, allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern = "dd::MM::yyyy")
	private LocalDate dateOfBirthOfTheAuthor;
	@JsonFormat(pattern = "dd::MM::yyyy")
	private LocalDate dateOfDeathOfTheAuthor;

	@ManyToMany(mappedBy = "listOfAuthors", fetch = FetchType.EAGER)
	// @JsonManagedReference
	// @JsonIgnore

	private List<Publication> listOfPublications;

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirthOfTheAuthor() {
		return dateOfBirthOfTheAuthor;
	}

	public LocalDate getDateOfDeathOfTheAuthor() {
		return dateOfDeathOfTheAuthor;
	}

	public List<Publication> getListOfPublications() {
		return listOfPublications;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirthOfTheAuthor(LocalDate dateOfBirthOfTheAuthor) {
		this.dateOfBirthOfTheAuthor = dateOfBirthOfTheAuthor;
	}

	public void setDateOfDeathOfTheAuthor(LocalDate dateOfDeathOfTheAuthor) {
		this.dateOfDeathOfTheAuthor = dateOfDeathOfTheAuthor;
	}

	public void setListOfPublications(List<Publication> listOfPublications) {
		this.listOfPublications = listOfPublications;
	}

	public Author(final Builder builder) {

		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.dateOfBirthOfTheAuthor = builder.dateOfBirthOfTheAuthor;
		this.dateOfDeathOfTheAuthor = builder.dateOfDeathOfTheAuthor;
		this.listOfPublications = builder.listOfPublications;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirthOfTheAuthor == null) ? 0 : dateOfBirthOfTheAuthor.hashCode());
		result = prime * result + ((dateOfDeathOfTheAuthor == null) ? 0 : dateOfDeathOfTheAuthor.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((listOfPublications == null) ? 0 : listOfPublications.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (dateOfBirthOfTheAuthor == null) {
			if (other.dateOfBirthOfTheAuthor != null)
				return false;
		} else if (!dateOfBirthOfTheAuthor.equals(other.dateOfBirthOfTheAuthor))
			return false;
		if (dateOfDeathOfTheAuthor == null) {
			if (other.dateOfDeathOfTheAuthor != null)
				return false;
		} else if (!dateOfDeathOfTheAuthor.equals(other.dateOfDeathOfTheAuthor))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (listOfPublications == null) {
			if (other.listOfPublications != null)
				return false;
		} else if (!listOfPublications.equals(other.listOfPublications))
			return false;
		return true;
	}

	public Author() {
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public static class Builder {

		private List<Publication> listOfPublications;
		private LocalDate dateOfDeathOfTheAuthor;
		private LocalDate dateOfBirthOfTheAuthor;
		private String lastName;
		private String firstName;

		public Builder listOfPublications(List<Publication> listOfPublications) {
			this.listOfPublications = listOfPublications;
			return this;
		}

		public Builder dateOfDeathOfTheAuthor(LocalDate dateOfDeathOfTheAuthor) {
			this.dateOfDeathOfTheAuthor = dateOfDeathOfTheAuthor;
			return this;
		}

		public Builder dateOfBirthOfTheAuthor(LocalDate dateOfBirthOfTheAuthor) {
			this.dateOfBirthOfTheAuthor = dateOfBirthOfTheAuthor;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Author build() {
			return new Author(this);
		}

	}
}
