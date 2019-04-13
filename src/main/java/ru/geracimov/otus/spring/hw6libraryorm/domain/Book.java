package ru.geracimov.otus.spring.hw6libraryorm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = {"authors", "genres", "reviews"})
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "PAGE_COUNT")
    private String pageCount;

    @Column(name = "ISBN")
    private String isbn;

    public Book(String name, int year, String pageCount, String isbn) {
        this.name = name;
        this.year = year;
        this.pageCount = pageCount;
        this.isbn = isbn;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID"))
    Set<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GENRE_BOOK",
            joinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID"))
    Set<Genre> genres;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Review> reviews;

    public void addAuthor(Author author) {
        authors.add(author);
        author.addBook(this);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.removeBook(this);
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
        genre.addBook(this);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
        genre.removeBook(this);
    }

    public void addReview(Review review) {
        reviews.add(review);
        review.setBook(this);
    }

    public void deleteReview(Review review) {
        reviews.remove(review);
        review.setBook(null);
    }
}
