package plm.services;

public abstract class AbstractOperation {

    public abstract void reserve(String userId, String reference, String version, int iteration);

    public abstract void update(String userId, String reference, String version, int iteration, String documentAttribute1, String documentAttribute2);

    public abstract void free(String userId, String reference, String version, int iteration);

    public abstract void setState(String userId, String reference, String version, int iteration, String state);

    public abstract void revise(String userId, String reference, String version, int iteration);
}
