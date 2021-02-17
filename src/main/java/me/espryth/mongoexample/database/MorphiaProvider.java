package me.espryth.mongoexample.database;

import dev.morphia.Morphia;
import me.espryth.mongoexample.Provider;
import me.espryth.mongoexample.student.SimpleStudent;
import me.espryth.mongoexample.student.Student;
import me.espryth.mongoexample.teacher.SimpleTeacher;
import me.espryth.mongoexample.teacher.Teacher;

public class MorphiaProvider implements Provider<Morphia> {

    private final Morphia morphia;

    public MorphiaProvider(){
        this.morphia = new Morphia().mapPackage("me.espryth.mongoexample").map(Student.class, Teacher.class);
    }

    @Override
    public Morphia get() {
        return morphia;
    }
}
