package me.espryth.mongoexample.student;

import me.espryth.mongoexample.Model;
import me.espryth.mongoexample.teacher.SimpleTeacher;

import java.util.List;

public interface Student extends Model {

    /**
     * Get the name of Student.
     * @return Name.
     */
    String getName();

    /**
     * Set name of Student.
     * @param name Name to set.
     */
    void setName(String name);

    /**
     * Get the {@link SimpleTeacher}'s of student
     * @return {@link List<SimpleTeacher>}
     */
    List<SimpleTeacher> getTeachers();
}
