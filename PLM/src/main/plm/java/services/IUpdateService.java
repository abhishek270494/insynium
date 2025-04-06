package java.services;

public interface IUpdateService {
    void update(String userId, String reference, String version, int iteration, String attribute1, String attribute2);
}
