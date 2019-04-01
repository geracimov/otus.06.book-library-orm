package ru.geracimov.otus.spring.hw6libraryorm;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class LibraryOrmApp {
    public static void main(String[] args) {
        SpringApplication.run(LibraryOrmApp.class);
        try {
            Console.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
