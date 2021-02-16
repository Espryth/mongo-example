package me.espryth.mongo.book.author;

import org.bson.types.ObjectId;

public interface Author {
    ObjectId getObjectId();
    String getName();
    Integer getAge();
}
