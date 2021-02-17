package me.espryth.mongoexample.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import me.espryth.mongoexample.model.Model;
import org.bson.UuidRepresentation;
import org.bson.conversions.Bson;
import org.mongojack.JacksonMongoCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MongoObjectRepository<T extends Model> implements ObjectRepository<T>{

    private final JacksonMongoCollection<T> mongoCollection;

    public MongoObjectRepository(MongoDatabase database,
                                 String collectionName,
                                 Class<T> clazz,
                                 ObjectMapper objectMapper) {

        this.mongoCollection = JacksonMongoCollection.builder()
                .withObjectMapper(objectMapper)
                .build(database.getCollection(collectionName, clazz), clazz, UuidRepresentation.STANDARD);
    }

    @Override
    public Optional<T> findOne(String id) {
        return Optional.ofNullable(mongoCollection.findOneById(id));
    }

    @Override
    public Optional<T> findOneByQuery(Bson query) {
        return Optional.ofNullable(mongoCollection.find(query).first());
    }

    @Override
    public List<T> find(String... ids) {
        List<T> foundDocs = new ArrayList<>();

        for(String id : ids) {
            Optional<T> optionalDoc = Optional.ofNullable(mongoCollection.findOneById(id));
            optionalDoc.ifPresent(foundDocs::add);
        }
        return null;
    }

    @Override
    public void save(T t) {
        mongoCollection.save(t);
    }

    @Override
    public void replace(String id, T t) {
        mongoCollection.replaceOneById(id, t);
    }

    @Override
    public void delete(String id) {
        mongoCollection.removeById(id);
    }

    @Override
    public void replaceIfPresent(String id, T t) {
        Optional<T> optionalDoc = findOne(id);

        if (optionalDoc.isPresent()) {
            replace(id, optionalDoc.get());
        } else {
            save(t);
        }
    }
}
