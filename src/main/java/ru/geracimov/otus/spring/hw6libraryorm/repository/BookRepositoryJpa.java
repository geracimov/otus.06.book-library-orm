package ru.geracimov.otus.spring.hw6libraryorm.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Author;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class BookRepositoryJpa implements BookRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Book getById(UUID id) {
        TypedQuery<Book> typedQuery = em.createQuery("select b from Book b  where  b.id = :id", Book.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public Set<Book> getBooksByAuthor(Author author) {
        TypedQuery<Book> typedQuery =
                em.createQuery("select b from Book b  where  :author MEMBER of b.authors", Book.class);
        typedQuery.setParameter("author", author);
        return typedQuery.getResultStream()
                         .collect(Collectors.toSet());
    }

}
