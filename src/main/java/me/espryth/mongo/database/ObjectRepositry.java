package me.espryth.mongo.database;

import dev.morphia.Key;
import dev.morphia.query.Query;

import java.util.List;
import java.util.Optional;

public interface ObjectRepositry<I, T> {

    void save(T t);

    Optional<T> get(I id, Class<T> clazz);

    void delete(T t);


}
