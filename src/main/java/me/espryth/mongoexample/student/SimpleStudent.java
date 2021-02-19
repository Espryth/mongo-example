package me.espryth.mongoexample.student;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import me.espryth.mongoexample.teacher.SimpleTeacher;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Entity(value = "student")
public class SimpleStudent implements Student{

    @Id private ObjectId id;

    private String name;
    private List<SimpleTeacher> teachers = new ArrayList<>();

    @Override
    public ObjectId getId() {
        return id;
    }

    @Override
    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<SimpleTeacher> getTeachers() {
        return teachers;
    }
}
