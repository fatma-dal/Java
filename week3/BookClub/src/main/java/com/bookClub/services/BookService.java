package com.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookClub.models.Book;
import com.bookClub.repositories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book getOneBook(Long id) {
		Optional<Book> b=bookRepo.findById(id);
		if(b.isEmpty()) {
			return null;
		}
		return b.get();
	}
	
	public Book create (Book newBook) {
		return bookRepo.save(newBook);
	}
	
	public Book updateBook(Long id,Book newBook) {
		newBook.setId(id);
		return bookRepo.save(newBook);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
		
	}
}
