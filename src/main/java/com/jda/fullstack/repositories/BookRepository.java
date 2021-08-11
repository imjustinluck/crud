package com.jda.fullstack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.fullstack.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();
	
	List<Book> findByTitleIs(String search);
	
	List<Book> findByDescriptionContaining(String search);
	
	List<Book> countByTitleContaining(String search);
	
	List<Book> deleteByTitleStartingWith(String search);
}
