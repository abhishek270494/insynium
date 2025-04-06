package java.services;

public interface IReviseService {
    void revise(String userId, String reference, String version, int iteration);
}
