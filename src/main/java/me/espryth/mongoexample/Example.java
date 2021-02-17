package me.espryth.mongoexample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import me.espryth.mongoexample.book.Book;
import me.espryth.mongoexample.book.BookImpl;
import me.espryth.mongoexample.book.author.Author;
import me.espryth.mongoexample.book.author.SimpleAuthor;
import me.espryth.mongoexample.database.*;
import me.espryth.mongoexample.database.jackson.ObjectMapperProvider;

import java.util.Optional;

public class Example {

    public static void main(String[] args) {

        Provider<MongoClient> mongoClientProvider = new MongoClientProvider(
                "mongodb://poto:poto123@pruebasmongo-shard-00-00.xmeac.mongodb.net:27017,pruebasmongo-shard-00-01.xmeac.mongodb.net:27017,pruebasmongo-shard-00-02.xmeac.mongodb.net:27017/Test?ssl=true&replicaSet=atlas-etlv8e-shard-0&authSource=admin&retryWrites=true&w=majority"
        );
        Provider<MongoDatabase> mongoDatabaseProvider = new MongoDatabaseProvider(mongoClientProvider);

        Provider<ObjectMapper> objectMapperProvider = new ObjectMapperProvider();

        Provider<ObjectRepository<Book>> bookRepositoryProvider = new ObjectRepositoryProvider<>(
                mongoDatabaseProvider.get(),
                "books",
                Book.class,
                objectMapperProvider.get());

        Provider<ObjectRepository<Author>> authorRepositoryProvider = new ObjectRepositoryProvider<>(
                mongoDatabaseProvider.get(),
                "authors",
                Author.class,
                objectMapperProvider.get());

        //Author antonio = new SimpleAuthor("Antonio", 90);
        //Book pito = new BookImpl("Pito", antonio);

        Optional<Book> book = bookRepositoryProvider.get().findOne("49f0f93c-b51b-4bf0-b48a-460033c0f88f");

    }
}
