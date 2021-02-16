package me.espryth.mongo.database.morphia;

import dev.morphia.Morphia;
import me.espryth.mongo.book.Book;
import me.espryth.mongo.book.author.Author;
import me.espryth.mongo.database.Provider;

public class MorphiaProvider implements Provider<Morphia> {

    private final Morphia morphia;

    public MorphiaProvider() {
        this.morphia = new Morphia().mapPackage("me.espryth.mongo").map(Book.class, Author.class);
    }

    @Override
    public Morphia get() {
        return morphia;
    }
}
