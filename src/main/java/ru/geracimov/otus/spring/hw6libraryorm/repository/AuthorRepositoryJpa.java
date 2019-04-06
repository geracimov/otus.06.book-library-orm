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
public class AuthorRepositoryJpa implements AuthorRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Author getById(UUID id) {
        TypedQuery<Author> typedQuery = em.createQuery("select a from Author a  where  a.id = :id", Author.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }


    @Override
    public Set<Author> getAuthorsByBook(Book book) {
        TypedQuery<Author> typedQuery =/*or join fetch a.books b ???*/
                em.createQuery("select a from Author a  where  :book MEMBER of a.books", Author.class);
        typedQuery.setParameter("book", book);
        return typedQuery.getResultStream()
                         .collect(Collectors.toSet());
    }
}
