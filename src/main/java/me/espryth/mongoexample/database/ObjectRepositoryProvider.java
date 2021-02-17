package me.espryth.mongoexample.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import me.espryth.mongoexample.model.Model;

public class ObjectRepositoryProvider<T extends Model> implements Provider<ObjectRepository<T>>{

    private final MongoObjectRepository<T> mongoObjectRepository;

    public ObjectRepositoryProvider(MongoDatabase database,
                                    String collectionName,
                                    Class<T> clazz,
                                    ObjectMapper objectMapper) {
        mongoObjectRepository = new MongoObjectRepository<>(
                database,
                collectionName,
                clazz,
                objectMapper);
    }

    @Override
    public ObjectRepository<T> get() {
        return mongoObjectRepository;
    }
}
