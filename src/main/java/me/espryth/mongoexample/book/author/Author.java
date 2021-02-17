package me.espryth.mongoexample.book.author;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.espryth.mongoexample.model.Model;

public interface Author extends Model {
    @JsonProperty("name")
    String getName();

    @JsonProperty("age")
    Integer getAge();

}
