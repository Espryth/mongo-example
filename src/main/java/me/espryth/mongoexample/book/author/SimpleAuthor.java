package me.espryth.mongoexample.book.author;

import java.util.UUID;

public class SimpleAuthor implements Author {

    private final String name;
    private final Integer age;
    private final String id;

    public SimpleAuthor(String name, Integer age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }
}
