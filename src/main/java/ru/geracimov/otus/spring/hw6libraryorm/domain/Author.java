package ru.geracimov.otus.spring.hw6libraryorm.domain;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "AUTHOR")
@ToString(exclude = "books")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTH")
    private LocalDate birth;

    public Author(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
