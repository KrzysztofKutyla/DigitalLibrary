package com.dl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dl.domain.Author;
import com.dl.domain.Publication;
import com.dl.repository.AuthorRepository;

@Service
public class AuthorService implements ServiceInterface<Author> {

	@Autowired
	private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public List<Author> findLastName(String name) {
		List<Author> names = authorRepository.findByLastName(name);
		return names;

	}

	public Iterable<Author> findAll() {
		Iterable<Author> authors = authorRepository.findAll();
		// Author author = names.iterator().next();
		return authors;
	}

	public List<Author> findByFirstNameAndLastName(String firstName, String lastName) {
		List<Author> names = authorRepository.findByFirstNameAndLastName(firstName, lastName);
		return names;
	}

	@Override
	public void delete(long id) {
		Author author = authorRepository.findById(id);
		List<Publication> publications = author.getListOfPublications();
		for (Publication p : publications) {
			p.getListOfAuthors().remove(author);
		}

		authorRepository.delete(author);

	}

	@Override
	public void add(Author author) {
		authorRepository.save(author);

	}

	@Override
	public void update(long id, Author author) {
		Author currentAuthor = authorRepository.findById(id);
		currentAuthor.setFirstName(author.getFirstName());
		currentAuthor.setLastName(author.getLastName());
		currentAuthor.setDateOfBirthOfTheAuthor(author.getDateOfBirthOfTheAuthor());
		currentAuthor.setDateOfDeathOfTheAuthor(author.getDateOfDeathOfTheAuthor());
		currentAuthor.setListOfPublications(author.getListOfPublications());
		authorRepository.save(currentAuthor);

	}
}
