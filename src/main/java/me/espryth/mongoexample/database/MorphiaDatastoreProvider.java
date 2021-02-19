package me.espryth.mongoexample.database;

import com.mongodb.client.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import me.espryth.mongoexample.Provider;

public class MorphiaDatastoreProvider implements Provider<Datastore> {

    private final Datastore datastore;

    public MorphiaDatastoreProvider(MongoClient mongoClient, String dbName) {
        this.datastore = Morphia.createDatastore(mongoClient, dbName);
    }

    @Override
    public Datastore get() {
        return datastore;
    }
}
