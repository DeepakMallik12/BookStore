package com.bookStore.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "book_register";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
	   List<Book> list = service.getAllBook();
	   
	   return new ModelAndView("available_books","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks() {
		return "myBooks";
	}
	
	
}
