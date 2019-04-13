package ru.geracimov.otus.spring.hw6libraryorm.repository;

import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Genre;

import java.util.Set;
import java.util.UUID;

public interface GenreRepository {

    Genre getById(UUID id);

    Set<Genre> getReviewsByBook(Book book);
}
