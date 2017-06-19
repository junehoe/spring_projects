package com.junehoe.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junehoe.books.models.Book;
import com.junehoe.books.services.BookService;

@Controller
public class Books {
	
	private final BookService bookService;
	
	public Books(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String books(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books/{index}")
	public String findBookByIndex(@PathVariable("index") int index, Model model) {
		Book book = bookService.findBookByIndex(index);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid Book book, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("book", book);
			return "redirect:/books/new";
		}
		else {
			bookService.addBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book book = bookService.findBookByIndex(id);
		if (book != null) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}
		else {
			return "redirect:/books";
		}
	}
	
	@PostMapping("/books/edit/{id}")
	public String updateBook(@PathVariable("id") int id, @Valid Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			bookService.updateBook(id, book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping(value="/books/delete/{id}")
	public String destroyBook(@PathVariable("id") int id) {
		bookService.destroyBook(id);
		return "redirect:/books";
	}
	
}