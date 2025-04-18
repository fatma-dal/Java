package com.bookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bookClub.models.Book;
import com.bookClub.models.User;
import com.bookClub.services.BookService;
import com.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	
	@GetMapping("/books")
	public String books(HttpSession session,Model model) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("user",userService.getUserById((Long)session.getAttribute("user_id")));
		model.addAttribute("books",bookService.getAllBooks());
		return "books";
	}
	
	@GetMapping("/books/new")
	public String bookForm(@ModelAttribute("newBook")Book newBook,HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		return "newBook";
	}
	
	@PostMapping("/books/new")
	public String addBokk(@Valid @ModelAttribute("newBook")Book newBook,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "newBook";
		}
		User user=userService.getUserById((long)session.getAttribute("user_id"));
		newBook.setUser(user);
		bookService.create(newBook);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id")Long id ,HttpSession session,Model model) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("book",bookService.getOneBook(id));
		return "showBook";
	}
	
	@GetMapping("/books/{id}/edit")
	public String getUpdatePage(@PathVariable("id")Long id,HttpSession session,Model model) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("newBook",bookService.getOneBook(id));
		return "editBook";
	}
	
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("newBook")Book newBook,BindingResult result,@PathVariable("id")Long id,HttpSession session) {
		if(result.hasErrors()) {
			return "editBook";
		}
		newBook.setUser(userService.getUserById((Long)session.getAttribute("user_id")));
		bookService.updateBook(id, newBook);
		return "redirect:/books";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id ) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}
