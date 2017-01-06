package com.dl.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import org.apache.commons.lang3.builder.ToStringBuilder;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Publication implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@TableGenerator(name = "Publ_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue = 10, allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;

	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			   name = "Publication_Author", 
			   joinColumns = @JoinColumn(name = "publication_id",
			   referencedColumnName="id",
			   nullable=true),
			   inverseJoinColumns = @JoinColumn(name = "author_id",
			   referencedColumnName="id",
			   nullable=true))
	 
	private List<Author> listOfAuthors;

	private String publisher;

	private String placeOfPublication;

	private int yearOfPublication;

	private String resourceIdentifier;

	private String language;
	@CreatedDate
	@JsonFormat(pattern = "dd::MM::yyyy")
	private LocalDate createdDate;
	@LastModifiedDate
	@JsonFormat(pattern = "dd::MM::yyyy")
	private LocalDate lastModifiedDate;
	

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<Author> getListOfAuthors() {
		return listOfAuthors;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getPlaceOfPublication() {
		return placeOfPublication;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public String getResourceIdentifier() {
		return resourceIdentifier;
	}

	public String getLanguage() {
		return language;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setListOfAuthors(List<Author> listOfAuthors) {
		this.listOfAuthors = listOfAuthors;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPlaceOfPublication(String placeOfPublication) {
		this.placeOfPublication = placeOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public void setResourceIdentifier(String resourceIdentifier) {
		this.resourceIdentifier = resourceIdentifier;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Publication(final Builder builder) {
		
		this.title = builder.title;
		this.description = builder.description;
		this.listOfAuthors = builder.listOfAuthors;
		this.publisher = builder.publisher;
		this.placeOfPublication = builder.placeOfPublication;
		this.yearOfPublication = builder.yearOfPublication;
		this.resourceIdentifier = builder.resourceIdentifier;
		this.language = builder.language;
		this.createdDate = builder.createdDate;
		this.lastModifiedDate = builder.lastModifiedDate;
	}
	
	public Publication() {
		
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this);
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((listOfAuthors == null) ? 0 : listOfAuthors.hashCode());
		result = prime * result + ((placeOfPublication == null) ? 0 : placeOfPublication.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((resourceIdentifier == null) ? 0 : resourceIdentifier.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearOfPublication;
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
		Publication other = (Publication) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (listOfAuthors == null) {
			if (other.listOfAuthors != null)
				return false;
		} else if (!listOfAuthors.equals(other.listOfAuthors))
			return false;
		if (placeOfPublication == null) {
			if (other.placeOfPublication != null)
				return false;
		} else if (!placeOfPublication.equals(other.placeOfPublication))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (resourceIdentifier == null) {
			if (other.resourceIdentifier != null)
				return false;
		} else if (!resourceIdentifier.equals(other.resourceIdentifier))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearOfPublication != other.yearOfPublication)
			return false;
		return true;
	}



	public static class Builder {
		
		private String title;
		private String description;
		private List<Author> listOfAuthors;
		private String publisher;
		private String placeOfPublication;
		private int yearOfPublication;
		private String resourceIdentifier;
		private String language;
		private LocalDate createdDate;
		private LocalDate lastModifiedDate;
		
		public Builder title(String title)
	    {
	        this.title = title;
			return this;
	    }
		
		public Builder descryption (String descryption)
	    {
	        this.description = descryption;
			return this;
	    }
		public Builder listOfAuthors(List<Author> listOfAuthors)
	    {
	        this.listOfAuthors = listOfAuthors;
			return this;
	    }
		
		public Builder publisher (String publisher)
	    {
	        this.publisher = publisher;
			return this;
	    }
		
		public Builder year (int yearOfPublication)
	    {
	        this.yearOfPublication = yearOfPublication;
			return this;
	    }
		
		public Builder placeOfPublication (String placeOfPublication) {
			this.placeOfPublication = placeOfPublication;
			return this;
		}
		
		public Builder resourceIdentifier (String resourceIdentifier)
	    {
	        this.resourceIdentifier = resourceIdentifier;
			return this;
	    }
		
		public Builder language (String language)
	    {
	        this.language = language;
			return this;
	    }
		
		public Builder createdDate(LocalDate createdDate)
	    {
	        this.createdDate = createdDate;
			return this;
	    }

		public Builder lastModifiedDate (LocalDate lastModifiedDate)
	    {
	        this.lastModifiedDate = lastModifiedDate;
			return this;
	    }
		 public Publication build()
	     {
	         return new Publication(this);
	     }

		
	}
}
