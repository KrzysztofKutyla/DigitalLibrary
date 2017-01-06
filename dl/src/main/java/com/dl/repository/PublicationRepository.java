package com.dl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dl.domain.Publication;

public interface PublicationRepository extends CrudRepository <Publication, Long>{

	List<Publication> findByTitle (String title);
	Publication findById (long id);
	Iterable<Publication> findAll ();
}
