package com.dl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dl.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	List<Author> findByLastName(String firstName);

	List<Author> findByFirstNameAndLastName(String firstName, String lastName);

	Author findById(long id);

	Iterable<Author> findAll();
}
