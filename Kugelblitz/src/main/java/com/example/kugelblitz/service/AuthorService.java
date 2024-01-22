package com.example.kugelblitz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kugelblitz.Exception.AuthorException;
import com.example.kugelblitz.Repo.AuthorRepo;
import com.example.kugelblitz.entity.Author;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepository;

	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public Author getAuthorById(Long authorId) throws AuthorException {
		return authorRepository.findById(authorId)
				.orElseThrow(() -> new AuthorException("Author not found with id: " + authorId));
	}

	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	public Author updateAuthor(Long authorId, Author updatedAuthor) throws AuthorException {

		Author existingAuthor = authorRepository.findById(authorId)
				.orElseThrow(() -> new AuthorException("Author not found with id: " + authorId));

		existingAuthor.setName(updatedAuthor.getName());
		existingAuthor.setBirthDate(updatedAuthor.getBirthDate());

		return authorRepository.save(existingAuthor);
	}

	public String deleteAuthor(Long authorId) throws AuthorException {
		Author existingAuthor = authorRepository.findById(authorId)
				.orElseThrow(() -> new AuthorException("Author not found with id: " + authorId));
		authorRepository.delete(existingAuthor);

		return new String("Auhtor id " + existingAuthor + " deleted");
	}

}
