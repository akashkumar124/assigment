package com.example.kugelblitz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kugelblitz.entity.Author;
import com.example.kugelblitz.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	List<Book> findByTitle(String title);

	List<Book> findByAuthor(Author author);

}
