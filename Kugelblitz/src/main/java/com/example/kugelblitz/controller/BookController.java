package com.example.kugelblitz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.kugelblitz.Exception.BookException;
import com.example.kugelblitz.entity.Book;
import com.example.kugelblitz.service.BookService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) throws BookException {
		Book book = bookService.getBookById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
		Book createdBook = bookService.createBook(book);
		return new ResponseEntity<Book>(createdBook, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book updatedBook)
			throws BookException {
		Book updated = bookService.updateBook(id, updatedBook);
		return new ResponseEntity<Book>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id) throws BookException {
		String message = bookService.deleteBook(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
