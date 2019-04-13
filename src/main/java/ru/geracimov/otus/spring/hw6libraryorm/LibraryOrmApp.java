package ru.geracimov.otus.spring.hw6libraryorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Author;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Genre;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Review;
import ru.geracimov.otus.spring.hw6libraryorm.repository.AuthorRepository;
import ru.geracimov.otus.spring.hw6libraryorm.repository.BookRepository;
import ru.geracimov.otus.spring.hw6libraryorm.repository.GenreRepository;
import ru.geracimov.otus.spring.hw6libraryorm.repository.ReviewRepository;

import java.util.UUID;


@SpringBootApplication
public class LibraryOrmApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryOrmApp.class);

        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        ReviewRepository reviewRepository = context.getBean(ReviewRepository.class);
        GenreRepository genreRepository = context.getBean(GenreRepository.class);

        Author chehov = authorRepository.getById(UUID.fromString("a3057eca-556e-11e9-8647-d663bd873d93"));
        System.out.println(chehov);

        Book warAndPeace = bookRepository.getById(UUID.fromString("502ccf7d-e30f-4335-88a4-06865e66fd03"));
        System.out.println(warAndPeace);

        Review niasilil = reviewRepository.getById(UUID.fromString("604c5054-588e-11e9-8647-d663bd873d93"));
        System.out.println(niasilil);

        Genre povest = genreRepository.getById(UUID.fromString("72b6aadc-5e06-11e9-8647-d663bd873d93"));
        System.out.println(povest);
    }
}
