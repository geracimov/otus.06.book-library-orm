package ru.geracimov.otus.spring.hw6libraryorm.repository;

import ru.geracimov.otus.spring.hw6libraryorm.domain.Author;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AuthorRepository extends CrudRepository<Author> {

    Set<Book> getBooksByAuthor(Author author);

    Set<Book> getBooksByAuthor(UUID uuid);

    List<Author> getAllAuthors();
}
