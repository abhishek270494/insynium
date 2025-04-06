package java.services;

public interface IStateService {
    void setState(String userId, String reference, String version, int iteration, String state);
}
