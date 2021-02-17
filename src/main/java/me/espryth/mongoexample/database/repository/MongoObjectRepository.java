package me.espryth.mongoexample.database.repository;

import dev.morphia.Datastore;
import me.espryth.mongoexample.Model;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MongoObjectRepository<T extends Model> implements ObjectRepository<T> {

    private final Datastore datastore;
    private final Class<T> clazz;

    public MongoObjectRepository(Datastore datastore, Class<T> clazz) {
        this.datastore = datastore;
        this.clazz = clazz;
    }

    @Override
    public Optional<T> findOneById(String id) {
        return Optional.ofNullable(datastore.find(clazz).field("_id").equal(new ObjectId(id)).first());
    }

    @Override
    public List<T> findById(String... ids) {
        List<T> foundDocs = new ArrayList<>();
        for(String id : ids) {
            Optional<T> optionalDoc = findOneById(id);
            optionalDoc.ifPresent(foundDocs::add);
        }
        return foundDocs;
    }

    @Override
    public void update(T t) {
        delete(t);
        save(t);
    }

    @Override
    public void save(T t) {
        datastore.save(t);
    }

    @Override
    public void delete(T t) {
        datastore.delete(t);
    }
}
