package com.example.kugelblitz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kugelblitz.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

}
