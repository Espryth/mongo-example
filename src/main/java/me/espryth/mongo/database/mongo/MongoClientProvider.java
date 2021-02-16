package me.espryth.mongo.database.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import me.espryth.mongo.database.Provider;

public class MongoClientProvider implements Provider<MongoClient> {

    private final MongoClient mongoClient;

    public MongoClientProvider(String uri) {
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        this.mongoClient = new MongoClient(mongoClientURI);
    }

    @Override
    public MongoClient get() {
        return mongoClient;
    }
}
