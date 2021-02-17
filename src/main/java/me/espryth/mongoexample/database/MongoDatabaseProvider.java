package me.espryth.mongoexample.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseProvider implements Provider<MongoDatabase> {

    private final MongoDatabase mongoDatabase;

    public MongoDatabaseProvider(Provider<MongoClient> mongoClientProvider) {
        this.mongoDatabase = mongoClientProvider.get().getDatabase("Test");
    }

    @Override
    public MongoDatabase get() {
        return mongoDatabase;
    }
}
