package me.espryth.mongo.database.morphia;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import me.espryth.mongo.database.Provider;

public class MorphiaDatastoreProvider implements Provider<Datastore> {

    private final Datastore datastore;

    public MorphiaDatastoreProvider(Morphia morphia, MongoClient client) {
        this.datastore = morphia.createDatastore(client, "Test");
    }

    @Override
    public Datastore get() {
        return datastore;
    }
}
