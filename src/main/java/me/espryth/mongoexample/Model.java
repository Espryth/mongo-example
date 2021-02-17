package me.espryth.mongoexample;

import org.bson.types.ObjectId;

/**
 * A interface to implement the
 * {@link ObjectId} on any Object
 * and making it storable.
 */
public interface Model {

    /**
     * Get the {@link ObjectId} of object
     * @return ObjectId
     */
    ObjectId getId();

    /**
     * Set {@link ObjectId} of object
     * @param id ObjectId to set
     */
    void setId(ObjectId id);

}
