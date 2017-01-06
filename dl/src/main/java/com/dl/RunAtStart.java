package com.dl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dl.domain.Author;
import com.dl.domain.Publication;
import com.dl.repository.AuthorRepository;
import com.dl.repository.PublicationRepository;

@Component
public class RunAtStart {

	private final PublicationRepository publicationRepository;
	private final AuthorRepository authorRepository;

	@Autowired
	public RunAtStart(PublicationRepository publicationRepository, AuthorRepository authorRepository) {
		this.publicationRepository = publicationRepository;
		this.authorRepository = authorRepository;

	}

	@PostConstruct
	public void runAtStart() {

		List<Author> listOfAuthors = new ArrayList<Author>();
		List<Author> listOfAuthors2 = new ArrayList<Author>();
		List<Publication> listOfPublications = new ArrayList<Publication>();
		List<Publication> listOfPublications2 = new ArrayList<Publication>();

		Publication publication = new Publication.Builder().title("Tytuł").descryption("opis")
				.listOfAuthors(listOfAuthors).language("polski").publisher("wydawca").placeOfPublication("Opole")
				.resourceIdentifier("s").year(2000).build();
		Publication publication2 = new Publication.Builder().title("Tytuł2").descryption("opis")
				.listOfAuthors(listOfAuthors2).language("polski").publisher("wydawca").placeOfPublication("Opole")
				.resourceIdentifier("s").year(2000).build();

		Author author = new Author.Builder().firstName("Karol").lastName("Wiśniewski")
				.dateOfBirthOfTheAuthor(LocalDate.of(1911, 12, 12)).dateOfDeathOfTheAuthor(LocalDate.of(1991, 11, 11))
				.listOfPublications(listOfPublications).build();

		Author author2 = new Author.Builder().firstName("Magdalena").lastName("Malinowska")
				.dateOfBirthOfTheAuthor(LocalDate.of(1984, 12, 12)).listOfPublications(listOfPublications).build();

		Author author3 = new Author.Builder().firstName("Henryk").lastName("Kowalski")
				.dateOfBirthOfTheAuthor(LocalDate.of(1980, 12, 12)).listOfPublications(listOfPublications2).build();

		Author author4 = new Author.Builder().firstName("Jan").lastName("Nowak")
				.dateOfBirthOfTheAuthor(LocalDate.of(1911, 12, 12)).dateOfDeathOfTheAuthor(LocalDate.of(1991, 11, 11))
				.build();

		listOfPublications.add(publication);
		listOfPublications2.add(publication2);
		listOfAuthors.add(author);
		listOfAuthors.add(author2);
		listOfAuthors2.add(author3);

		authorRepository.save(author);
		authorRepository.save(author2);
		authorRepository.save(author3);
		authorRepository.save(author4);
		publicationRepository.save(publication);
		publicationRepository.save(publication2);

		System.out.println(author2.getListOfPublications());

	}
}
