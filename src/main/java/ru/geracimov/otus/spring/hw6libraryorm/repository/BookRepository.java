package ru.geracimov.otus.spring.hw6libraryorm.repository;

import ru.geracimov.otus.spring.hw6libraryorm.domain.Author;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Review;

import java.util.List;
import java.util.Set;

public interface BookRepository extends CrudRepository<Book> {

    Set<Book> getBooksByAuthor(Author author);

    List<Book> getAllBooks();

}
