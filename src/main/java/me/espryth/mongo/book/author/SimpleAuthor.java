package me.espryth.mongo.book.author;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import org.bson.types.ObjectId;

@Entity(value = "author", noClassnameStored = true)
public class SimpleAuthor implements Author {

    @Id private final ObjectId objectId;
    @Property private final String name;
    @Property private final Integer age;

    public SimpleAuthor(String name, Integer age) {
        this.objectId = new ObjectId();
        this.name = name;
        this.age = age;
    }

    @Override
    public ObjectId getObjectId() {
        return objectId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAge() {
        return age;
    }
}
