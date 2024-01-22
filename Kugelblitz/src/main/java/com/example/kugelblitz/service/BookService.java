package com.example.kugelblitz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kugelblitz.Exception.BookException;
import com.example.kugelblitz.Repo.BookRepo;
import com.example.kugelblitz.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(Long bookId) throws BookException {
		return bookRepository.findById(bookId)
				.orElseThrow(() -> new BookException("Book not found with id: " + bookId));
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Long bookId, Book updatedBook) throws BookException {

		Book existingBook = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookException("Book not found with id: " + bookId));

		existingBook.setTitle(updatedBook.getTitle());
		existingBook.setIsbn(updatedBook.getIsbn());
		existingBook.setQuantity(updatedBook.getQuantity());
		existingBook.setAuthor(updatedBook.getAuthor());

		return bookRepository.save(existingBook);
	}

	public String deleteBook(Long bookId) throws BookException {
		Book bookToDelete = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookException("Book not found with id: " + bookId));
		bookRepository.delete(bookToDelete);

		return new String("Auhtor id " + bookToDelete + " deleted");
	}

}
