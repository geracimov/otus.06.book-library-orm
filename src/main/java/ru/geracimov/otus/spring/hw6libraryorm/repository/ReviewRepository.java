package ru.geracimov.otus.spring.hw6libraryorm.repository;

import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Review;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review> {

    List<Review> getReviewsByBook(Book book);

    List<Review> getAllReviews();
}
