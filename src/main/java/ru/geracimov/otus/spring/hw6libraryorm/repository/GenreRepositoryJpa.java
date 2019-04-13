package ru.geracimov.otus.spring.hw6libraryorm.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Genre;
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
public class GenreRepositoryJpa implements GenreRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre getById(UUID id) {
        TypedQuery<Genre> typedQuery = em.createQuery("select g from Genre g  where  g.id = :id", Genre.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public Set<Genre> getReviewsByBook(Book book) {
        TypedQuery<Genre> typedQuery = em.createQuery("select g from Genre g  where  g.book = :book ", Genre.class);
        typedQuery.setParameter("book", book);
        return typedQuery.getResultStream()
                         .collect(Collectors.toSet());
    }

}
