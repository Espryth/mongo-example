package me.espryth.mongoexample;

public interface Provider<T> {
    /**
     * Provides the object {@link T}.
     * @return {@link T}
     */
    T get();
}
