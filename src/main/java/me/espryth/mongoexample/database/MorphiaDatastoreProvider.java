package me.espryth.mongoexample.database;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import me.espryth.mongoexample.Provider;

public class MorphiaDatastoreProvider implements Provider<Datastore> {

    private final Datastore datastore;

    public MorphiaDatastoreProvider(Morphia morphia, MongoClient mongoClient) {
        this.datastore = morphia.createDatastore(mongoClient, "Test");
    }

    @Override
    public Datastore get() {
        return datastore;
    }
}
