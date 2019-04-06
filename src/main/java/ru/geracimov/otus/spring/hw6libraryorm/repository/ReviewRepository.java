package ru.geracimov.otus.spring.hw6libraryorm.repository;

import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Review;

import java.util.Set;
import java.util.UUID;

public interface ReviewRepository {

    Review getById(UUID id);

    Set<Review> getReviewsByBook(Book book);
}
