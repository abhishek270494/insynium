package java.services;

public interface EntityService {

    void reserve(String userId, String reference, String version, int iteration);

    void update(String userId, String reference, String version, int iteration, String documentAttribute1, String documentAttribute2);

    void free(String userId, String reference, String version, int iteration);

    void setState(String userId, String reference, String version, int iteration, String state);

    void revise(String userId, String reference, String version, int iteration);
}
