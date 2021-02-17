package me.espryth.mongoexample.database.repository;

import me.espryth.mongoexample.Model;

import java.util.List;
import java.util.Optional;

/**
 * Credits to iAlexT: https://github.com/iAlexT
 */
public interface ObjectRepository<T extends Model> {

    /**
     * Searches the object {@link T} using {@link org.bson.types.ObjectId}
     * @param id is transformed to {@link org.bson.types.ObjectId} from {@link String}
     * @return {@link Optional<T>}
     */
    Optional<T> findOneById(String id);

    /**
     * Searches multiple objects {@link T} using {@link org.bson.types.ObjectId}
     * @param ids are transformed to {@link org.bson.types.ObjectId} from {@link String}
     * @return {@link List<T>}
     */
    List<T> findById(String... ids);

    /**
     * Updates the object {@link T}
     * @param t T
     */
    void update(T t);

    /**
     * Saves the object {@link T}
     * @param t T
     */
    void save(T t);

    /**
     * Deletes the object  {@link T}
     * @param t T
     */
    void delete(T t);
}
