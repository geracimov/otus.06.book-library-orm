package ru.geracimov.otus.spring.hw6libraryorm.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "AUTHOR")
public class Author {
    @Id
    @Getter
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Getter
    @Column(name = "NAME")
    private String name;

    @Getter
    @Column(name = "BIRTH")
    private LocalDate birth;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

}
