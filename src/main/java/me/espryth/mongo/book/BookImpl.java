package me.espryth.mongo.book;

import dev.morphia.annotations.*;
import me.espryth.mongo.book.author.Author;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

@Entity(value = "book", noClassnameStored = true)
public class BookImpl implements Book {

    @Id private final ObjectId objectId;
    @Reference private final List<Author> authors;
    @Property private final String title;

    public BookImpl(String title, Author... authors) {
        this.objectId = new ObjectId();
        this.authors = Arrays.asList(authors);
        this.title = title;
    }

    @Override
    public ObjectId getObjectId() {
        return objectId;
    }

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
