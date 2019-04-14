package ru.geracimov.otus.spring.hw6libraryorm.repository;


import java.util.UUID;

public interface CrudRepository<T> {

    void create(T t);

    T read(Class<T> clazz, UUID uuid);

    void update(T t);

    void delete(T t);
}
