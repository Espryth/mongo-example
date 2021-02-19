package me.espryth.mongoexample;

import com.mongodb.client.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.DatastoreImpl;
import dev.morphia.Morphia;
import me.espryth.mongoexample.database.MongoClientProvider;
import me.espryth.mongoexample.database.repository.ObjectRepository;
import me.espryth.mongoexample.database.repository.ObjectRepositoryProvider;
import me.espryth.mongoexample.student.SimpleStudent;
import me.espryth.mongoexample.teacher.SimpleTeacher;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MongoExample {

    private static Provider<ObjectRepository<SimpleStudent>> studentRepositoryProvider;

    public static void main(String... args) {

        Provider<MongoClient> mongoClientProvider = new MongoClientProvider(
                "mongodb://poto:poto123@pruebasmongo-shard-00-00.xmeac.mongodb.net:27017,pruebasmongo-shard-00-01.xmeac.mongodb.net:27017,pruebasmongo-shard-00-02.xmeac.mongodb.net:27017/Test?ssl=true&replicaSet=atlas-etlv8e-shard-0&authSource=admin&retryWrites=true&w=majority"
        );
        Datastore morphia = Morphia.createDatastore(mongoClientProvider.get(), "Test");

        studentRepositoryProvider = new ObjectRepositoryProvider<>(morphia, SimpleStudent.class);

    }

    /**
     * Create a {@link SimpleStudent}.
     * @param name Name to set.
     * @param teachers Teachers to set.
     */
    private static void createStudent(String name, SimpleTeacher... teachers) {

        SimpleStudent student = new SimpleStudent();
        student.setId(new ObjectId());
        student.setName(name);
        student.getTeachers().addAll(Arrays.asList(teachers));

        studentRepositoryProvider.get().save(student);

    }

    /**
     * Get {@link SimpleStudent} from database.
     * @param id Id of the Student you want obtain.
     * @return {@link Optional<SimpleStudent>}
     */
    private static Optional<SimpleStudent> getStudentFromDatabase(String id) {
        return studentRepositoryProvider.get().findOneById(id);
    }

    /**
     * Get a {@link SimpleStudent} matters list.
     * @param id Id of the Student you want get his matters.
     * @return {@link List} of Student matters.
     */
    private static List<String> getStudentMatters(String id) {
        Optional<SimpleStudent> student = getStudentFromDatabase(id);

        List<String> matters = new ArrayList<>();

        student.ifPresent(simpleStudent -> simpleStudent.getTeachers().forEach(teacher -> matters.add(teacher.getMatter())));

        return matters;
    }

}
