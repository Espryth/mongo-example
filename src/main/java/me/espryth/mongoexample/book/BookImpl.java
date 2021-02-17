package me.espryth.mongoexample.book;

import me.espryth.mongoexample.book.author.Author;

import java.beans.ConstructorProperties;
import java.util.UUID;

public class BookImpl implements Book {

    private final String title;
    private final String id;
    private final Author author;

    
    public BookImpl(String title, Author author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    @Override
    public String getId() {
        return id;
    }
}
