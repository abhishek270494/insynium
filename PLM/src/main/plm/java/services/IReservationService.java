package java.services;

public interface IReservationService {
    void reserve(String userId, String reference, String version, int iteration);
}
