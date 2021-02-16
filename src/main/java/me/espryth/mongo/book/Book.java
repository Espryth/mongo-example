package me.espryth.mongo.book;

import dev.morphia.annotations.Field;
import dev.morphia.annotations.Index;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexes;
import me.espryth.mongo.book.author.Author;
import org.bson.types.ObjectId;

import java.util.List;

public interface Book {
    ObjectId getObjectId();
    List<Author> getAuthors();
    String getTitle();

}
