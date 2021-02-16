package me.espryth.mongo.database;

public interface Provider<T> {
    T get();
}
