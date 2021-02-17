package me.espryth.mongoexample.database.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import me.espryth.mongoexample.book.Book;
import me.espryth.mongoexample.book.BookImpl;
import me.espryth.mongoexample.book.author.Author;
import me.espryth.mongoexample.book.author.SimpleAuthor;

public class InterfaceDeserializer {

    public static SimpleModule getAbstractTypes() {
        SimpleModule module = new SimpleModule("InterfaceDeserializerModule", Version.unknownVersion());
        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver()
                .addMapping(Book.class, BookImpl.class)
                .addMapping(Author.class, SimpleAuthor.class);
        module.setAbstractTypes(resolver);
        return module;
    }
}
