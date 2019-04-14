package ru.geracimov.otus.spring.hw6libraryorm.repository;

import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Genre;

import java.util.List;
import java.util.Set;

public interface GenreRepository extends CrudRepository<Genre> {

    Set<Genre> getGenresByBook(Book book);

    List<Genre> getAllGenres();
}
