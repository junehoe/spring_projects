package com.junehoe.books.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.junehoe.books.models.Book;

@Service
public class BookService {
	
	// Initialize the books variables with values
	private List<Book> books = new ArrayList(Arrays.asList(
			new Book("Harry Potter", "A wizard with glasses", "English", 300),
			new Book("Harry Pothead", "A high wizard", "Dank English", 420),
			new Book("Some Great Book", "It's a great book", "Korean", 200),
			new Book("My Biography", "Don't read it", "English", 900),
			new Book("ShiiFucc", "Lololol", "Portuguese", 200)
	));
	
	public List<Book> allBooks() {
		return books;
	}

	public Book findBookByIndex(int index) {
		if (index < books.size()) {
			return books.get(index);
		}
		else {
			return null;
		}
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void updateBook(int id, Book book) {
		if (id < books.size()) {
			books.set(id, book);
		}
	}
	
	public void destroyBook(int id) {
		if (id < books.size()) {
			books.remove(id);
		}
	}
}
