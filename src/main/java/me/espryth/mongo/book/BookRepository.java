package me.espryth.mongo.book;

import dev.morphia.Datastore;
import dev.morphia.Key;
import dev.morphia.query.Query;
import me.espryth.mongo.database.ObjectRepositry;
import me.espryth.mongo.database.Provider;
import org.bson.types.ObjectId;

import java.util.Optional;

public class BookRepository implements ObjectRepositry<ObjectId, Book> {

    private final Provider<Datastore> datastoreProvider;

    public BookRepository(Provider<Datastore> datastoreProvider) {
        this.datastoreProvider = datastoreProvider;
    }

    @Override
    public void save(Book book) {
        datastoreProvider.get().save(book);
    }

    @Override
    public Optional<Book> get(ObjectId id, Class<Book> clazz) {
        return Optional.ofNullable(datastoreProvider.get().createQuery(clazz).field("_id").equal(id).first());
    }

    @Override
    public void delete(Book book) {
        datastoreProvider.get().delete(book);
    }
}
