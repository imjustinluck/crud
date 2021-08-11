package com.jda.fullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jda.fullstack.models.Book;
import com.jda.fullstack.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	 // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
//    Update
    public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
        Book book = bookRepository.findById(id).get();
        book.setTitle(title);
        book.setDescription(desc);
        book.setLanguage(lang);
        book.setNumberOfPages(pages);
        return bookRepository.save(book);
    }
    
//    Delete
    public void delete(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	bookRepository.deleteById(id);
        }
    }
}
