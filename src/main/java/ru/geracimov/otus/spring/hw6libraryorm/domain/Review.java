package ru.geracimov.otus.spring.hw6libraryorm.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "REVIEW")
public class Review {
    @Id
    @Getter
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Getter
    @Column(name = "REVIEWER_NAME")
    private String name;

    @Getter
    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

}
