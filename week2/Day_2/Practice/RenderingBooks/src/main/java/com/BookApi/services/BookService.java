package com.BookApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookApi.models.Book;
import com.BookApi.repositories.BookRepo;

@Service
public class BookService {
	@Autowired
	BookRepo bookRepo;
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book>optionalBook=bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	public Book updateBook(long id,Book newBook) {
		Book currentBook=this.findBook(id);
		currentBook.setTitle(newBook.getTitle());
		currentBook.setLanguage(newBook.getLanguage());
		currentBook.setNumberOfPages(newBook.getNumberOfPages());
		currentBook.setDescription(newBook.getDescription());
		return bookRepo.save(currentBook);
	}
	
	public void deleteBook(long id) {
		bookRepo.deleteById(id);
	}
}
