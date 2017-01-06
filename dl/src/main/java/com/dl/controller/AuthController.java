package com.dl.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.domain.Author;
import com.dl.domain.Publication;
import com.dl.service.AuthorService;
import com.dl.service.PublicationService;


@RestController
@Transactional
@RequestMapping
public class AuthController {
	@Autowired
	private final AuthorService authorService;
	private final PublicationService publicationService;
	
	public AuthController(AuthorService authorService, PublicationService publicationService) {
		this.authorService = authorService;
		this.publicationService = publicationService;
	}

	@RequestMapping(value = "authors/get/getAll", method = RequestMethod.GET)
	public @ResponseBody Iterable<Author> getAllAutors() {
		Iterable<Author> authors = authorService.findAll();
		return authors;
	}

	@GetMapping("authors/get/{getLastName}")
	public List<Author> getName(@PathVariable("getLastName") String name) {
		List<Author> names = authorService.findLastName(name);
		
		return names;
	}

	@GetMapping("authors/get/{getFirstName}/{getLastName}")
	public List<Author> getFirstNameAndLastName(@PathVariable("getFirstName") String firstName,
			@PathVariable("getLastName") String lastName) {
		List<Author> names = authorService.findByFirstNameAndLastName(firstName, lastName);
		return names;
	}
	
	
	@PostMapping("authors/add/")
	public void addAuthor(@RequestBody Author author) {
		
		authorService.add(author);
		
	}
	

	@DeleteMapping("authors/delete/{getId}")
	public void deleteAuthor(@PathVariable("getId") long id) {
		authorService.delete(id);
	
	}
	
	@RequestMapping(value = "authors/update/{getId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
		    produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateAuthor(@PathVariable("getId") long id, @RequestBody Author author) {
		
		authorService.update(id, author);
	
	}

	// PUBLICATIONS
	
	@RequestMapping(value = "publications/get/getAll", method = RequestMethod.GET)
	public @ResponseBody Iterable<Publication> getAllPublication() {
		Iterable<Publication> publications = publicationService.findAll();
		return publications;
	}

	@GetMapping("publications/get/{geTitle}")
	public List<Publication> getTitle(@PathVariable("getTitle") String title) {
		List<Publication> publications = publicationService.findTitle(title);
		return publications;
	}

	@RequestMapping("publications/add/")
	public void addPublication(@RequestBody Publication publication) {
		
		publicationService.add(publication);
		
	}
	
	@RequestMapping(value = "publications/update/{getId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
		    produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updatePublication(@PathVariable("getId") long id, @RequestBody Publication publication) {
		
      List<Author>authors = publication.getListOfAuthors();
     
      for (Author author : authors){
    	  long idAuthor = author.getId();
    	  System.out.println(idAuthor);
    	  authorService.update(idAuthor, author);
      }
		
		publicationService.update(id, publication);
	}
	
	@DeleteMapping("publications/delete/{getId}")
	public void deletePublication(@PathVariable("getId") long id) {
		publicationService.delete(id);

}
}
