package me.espryth.mongo;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import me.espryth.mongo.book.Book;
import me.espryth.mongo.book.BookImpl;
import me.espryth.mongo.book.BookRepository;
import me.espryth.mongo.database.ObjectRepositry;
import me.espryth.mongo.database.mongo.MongoClientProvider;
import me.espryth.mongo.database.Provider;
import me.espryth.mongo.database.morphia.MorphiaDatastoreProvider;
import me.espryth.mongo.database.morphia.MorphiaProvider;
import org.bson.types.ObjectId;

import java.util.Optional;

public class MainClass {

    private static Provider<Morphia> morphiaProvider;
    private static Provider<MongoClient> mongoClientProvider;
    private static Provider<Datastore> datastoreProvider;

    private static ObjectRepositry<ObjectId, Book> bookObjectRepositry;

    public static void main(String[] args) {
        morphiaProvider = new MorphiaProvider();
        mongoClientProvider = new MongoClientProvider("mongodb://poto:poto123@pruebasmongo-shard-00-00.xmeac.mongodb.net:27017,pruebasmongo-shard-00-01.xmeac.mongodb.net:27017,pruebasmongo-shard-00-02.xmeac.mongodb.net:27017/Test?ssl=true&replicaSet=atlas-etlv8e-shard-0&authSource=admin&retryWrites=true&w=majority");
        datastoreProvider = new MorphiaDatastoreProvider(morphiaProvider.get(), mongoClientProvider.get());
        bookObjectRepositry = new BookRepository(datastoreProvider);
        /*
        Author author1 = new SimpleAuthor("Rodolfo", 50);
        Author author2 =  new SimpleAuthor("Antonio", 26);
        Author author3 = new SimpleAuthor("Asdasd", 60);
        Author author4 =  new SimpleAuthor("fdsgdfs", 30);

        Book book1 = new BookImpl(
                "super libro",
                author1, author2);
        Book book2 = new BookImpl(
                "ultra libro",
                author3, author4, author1);

        datastoreProvider.get().ensureIndexes();
        datastoreProvider.get().save(author1);
        datastoreProvider.get().save(author2);
        datastoreProvider.get().save(author3);
        datastoreProvider.get().save(author4);
        datastoreProvider.get().save(book1);
        datastoreProvider.get().save(book2);

         */

        Optional<Book> book = bookObjectRepositry.get(new ObjectId("602c3215bc31e4677516ba93"), Book.class);

        System.out.println(book);
    }

    public static Provider<Morphia> getMorphiaProvider() {
        return morphiaProvider;
    }

    public static Provider<MongoClient> getMongoClientProvider() {
        return mongoClientProvider;
    }

    public static Provider<Datastore> getDatastoreProvider() {
        return datastoreProvider;
    }
}
