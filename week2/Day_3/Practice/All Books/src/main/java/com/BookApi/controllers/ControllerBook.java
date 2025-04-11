package com.BookApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BookApi.models.Book;
import com.BookApi.services.BookService;

@Controller
public class ControllerBook {
	@Autowired
	BookService bookService;
	@PostMapping("/books/create")
    public Book create( 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
		Book book=new Book(title,desc,lang,numOfPages);
         book = bookService.createBook(book);
        return book;
    }
	@PutMapping("/books/{id}")
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
	@GetMapping("/books")
	public String allBooks(Model model) {
		model.addAttribute("books",bookService.allBooks());
		return "index";
	}
	
	@DeleteMapping("/books/{id}")
	public void destroy(@PathVariable("id")Long id) {
		bookService.deleteBook(id);
	}
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id")Long id,Model model) {
		model.addAttribute("book",bookService.findBook(id) );
		return "show";
	}
}
