package ru.geracimov.otus.spring.hw6libraryorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Author;
import ru.geracimov.otus.spring.hw6libraryorm.domain.Book;
import ru.geracimov.otus.spring.hw6libraryorm.repository.AuthorRepository;
import ru.geracimov.otus.spring.hw6libraryorm.repository.BookRepository;

import java.util.UUID;


@SpringBootApplication
public class LibraryOrmApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryOrmApp.class);

        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        Author chehov = authorRepository.getById(UUID.fromString("a3057eca-556e-11e9-8647-d663bd873d93"));



    }
}
