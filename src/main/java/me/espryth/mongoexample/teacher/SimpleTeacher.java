package me.espryth.mongoexample.teacher;

import dev.morphia.annotations.Entity;

@Entity(value = "teacher", noClassnameStored = true)
public class SimpleTeacher implements Teacher{

    private String name;
    private String matter;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMatter() {
        return matter;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setMatter(String matter) {
        this.matter = matter;
    }
}
