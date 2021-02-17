package me.espryth.mongoexample.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.espryth.mongoexample.book.author.Author;
import me.espryth.mongoexample.model.Model;

public interface Book extends Model {

    @JsonProperty("title")
    String getTitle();

    @JsonProperty("author")
    Author getAuthor();
}
