package ru.geracimov.otus.spring.hw6libraryorm.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Review;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class ReviewRepositoryJpa implements ReviewRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Review getById(UUID id) {
        TypedQuery<Review> typedQuery = em.createQuery("select b from Review b  where  b.id = :id", Review.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public Set<Review> getReviewsByBook(Book book) {
        TypedQuery<Review> typedQuery = em.createQuery("select b from Review b  where  b.book = :book ", Review.class);
        typedQuery.setParameter("book", book);
        return typedQuery.getResultStream()
                         .collect(Collectors.toSet());
    }

}
