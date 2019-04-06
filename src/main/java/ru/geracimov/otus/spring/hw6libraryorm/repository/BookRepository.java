package ru.geracimov.otus.spring.hw6libraryorm.repository;

import ru.geracimov.otus.spring.hw6libraryorm.domain.Author;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;

import java.util.Set;
import java.util.UUID;

public interface BookRepository {

    Book getById(UUID id);

    Set<Book> getBooksByAuthor(Author author);
}
