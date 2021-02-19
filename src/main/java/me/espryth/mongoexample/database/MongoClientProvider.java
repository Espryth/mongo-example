package me.espryth.mongoexample.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import me.espryth.mongoexample.Provider;

public class MongoClientProvider implements Provider<MongoClient> {

    private final MongoClient mongoClient;

    public MongoClientProvider(String uri) {

        this.mongoClient = MongoClients.create(uri);
    }

    @Override
    public MongoClient get() {
        return mongoClient;
    }
}
