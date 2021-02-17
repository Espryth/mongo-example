package me.espryth.mongoexample.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import me.espryth.mongoexample.Provider;

public class MongoClientProvider implements Provider<MongoClient> {

    private final MongoClient mongoClient;

    public MongoClientProvider(String uri) {
        this.mongoClient = new MongoClient(new MongoClientURI(uri));
    }

    @Override
    public MongoClient get() {
        return mongoClient;
    }
}
