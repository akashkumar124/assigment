package com.example.kugelblitz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.kugelblitz.Exception.AuthorException;
import com.example.kugelblitz.entity.Author;
import com.example.kugelblitz.service.AuthorService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/viewAll")
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> allAuthor = authorService.getAllAuthors();
		return new ResponseEntity<List<Author>>(allAuthor, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long id) throws AuthorException {
		Author author = authorService.getAuthorById(id);
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
		Author createdAuthor = authorService.createAuthor(author);
		return new ResponseEntity<Author>(createdAuthor, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @Valid @RequestBody Author updatedAuthor)
			throws AuthorException {
		Author updated = authorService.updateAuthor(id, updatedAuthor);
		return new ResponseEntity<Author>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable Long id) throws AuthorException {
		String message = authorService.deleteAuthor(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
