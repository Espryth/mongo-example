package me.espryth.mongoexample.database;

import me.espryth.mongoexample.model.Model;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;

public interface ObjectRepository<T extends Model> {

    Optional<T> findOne(String id);

    Optional<T> findOneByQuery(Bson query);

    List<T> find(String... ids);

    void save(T t);

    void replace(String id, T t);

    void delete(String id);

    void replaceIfPresent(String id, T t);
}
