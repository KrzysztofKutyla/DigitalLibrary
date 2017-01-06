package com.dl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dl.domain.Author;
import com.dl.domain.Publication;
import com.dl.repository.AuthorRepository;
import com.dl.repository.PublicationRepository;

@Service
public class PublicationService implements ServiceInterface <Publication> {
	
	@Autowired
	private final PublicationRepository publicationRepository;
	private final AuthorRepository authorRepository;
	
	public PublicationService(PublicationRepository publicationRepository, AuthorRepository authorRepository) {
		this.publicationRepository = publicationRepository;
		this.authorRepository = authorRepository;
	}

	public List<Publication> findTitle (String title) {
		List<Publication> names = publicationRepository.findByTitle(title);
		return names;
		
	}
	
	public Iterable<Publication> findAll() {
		Iterable<Publication> publications = publicationRepository.findAll();
		return publications;
	}


@Override
public void delete(long id) {
	Publication publication = publicationRepository.findById(id);
	List<Author> authors = publication.getListOfAuthors();
	for(Author a : authors){
		a.getListOfPublications().remove(publication);
		 }
	
	publicationRepository.delete(publication);
	
}

@Override
public void add(Publication publication) {

	publicationRepository.save(publication);
}

@Override
public void update(long id, Publication publication) {
	Publication currentPublication = publicationRepository.findById(id);
    currentPublication.setTitle(publication.getTitle());
	currentPublication.setDescription(publication.getDescription());
	currentPublication.setLanguage(publication.getLanguage());
	currentPublication.setPublisher(publication.getPublisher());
	currentPublication.setPlaceOfPublication(publication.getPlaceOfPublication());
	currentPublication.setYearOfPublication(publication.getYearOfPublication());
	currentPublication.setResourceIdentifier(publication.getResourceIdentifier());
	//currentPublication.setListOfAuthors(publication.getListOfAuthors());
	publicationRepository.save(currentPublication);
	
}
}
