package com.BookApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookApi.models.Book;
import com.BookApi.services.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	@GetMapping("/api/books")
	public List<Book> allBooks(){
		return bookService.allBooks();
	}
	@PostMapping("/api/books/create")
    public Book create( 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
		Book book=new Book(title,desc,lang,numOfPages);
         book = bookService.createBook(book);
        return book;
    }
	@PutMapping("/api/books/{id}")
	public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
		Book book=new Book(title,desc,lang,numOfPages);
         book = bookService.updateBook(id,book);
        return book;
    }
	
	@DeleteMapping("/api/books/{id}")
	public void destroy(@PathVariable("id")Long id) {
		bookService.deleteBook(id);
	}
	
}
