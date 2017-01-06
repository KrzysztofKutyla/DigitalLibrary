package com.dl.service;

import java.util.List;
import java.util.Map;

import com.dl.domain.Author;
import com.dl.domain.Publication;

public interface ServiceInterface <T> {

	Iterable<T> findAll();
	void delete(long id);
	void add (T t);
	void update (long id, T t);
	
}
