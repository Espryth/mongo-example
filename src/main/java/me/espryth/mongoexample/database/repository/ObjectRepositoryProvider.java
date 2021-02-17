package me.espryth.mongoexample.database.repository;

import dev.morphia.Datastore;
import me.espryth.mongoexample.Model;
import me.espryth.mongoexample.Provider;

public class ObjectRepositoryProvider<T extends Model> implements Provider<ObjectRepository<T>> {

    private final ObjectRepository<T> objectRepository;

    public ObjectRepositoryProvider(Datastore datastore, Class<T> clazz) {
        this.objectRepository = new MongoObjectRepository<>(datastore, clazz);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectRepository<T> get() {
        return objectRepository;
    }
}
