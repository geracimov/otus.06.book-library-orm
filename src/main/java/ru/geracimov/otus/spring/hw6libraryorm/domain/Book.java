package ru.geracimov.otus.spring.hw6libraryorm.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "BOOK")
public class Book {
    @ManyToMany
    @JoinTable(name = "AUTHOR_BOOK",
               joinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"),
               inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID"))
    Set<Author> authors;
    @Id
    @Getter
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;
    @Getter
    @Column(name = "NAME")
    private String name;
    @Getter
    @Column(name = "YEAR")
    private int year;
    @Getter
    @Column(name = "PAGE_COUNT")
    private String pageCount;
    @Getter
    @Column(name = "ISBN")
    private String isbn;
}
