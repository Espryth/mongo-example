package me.espryth.mongoexample.teacher;

public interface Teacher {

    /**
     * Get the name of Teacher.
     * @return Name.
     */
    String getName();

    /**
     * Get the matter of Teacher.
     * @return Matter.
     */
    String getMatter();

    /**
     * Set name of Teacher.
     * @param name Name to set.
     */
    void setName(String name);

    /**
     * Set matter of Teacher.
     * @param matter Matter to set.
     */
    void setMatter(String matter);
}
