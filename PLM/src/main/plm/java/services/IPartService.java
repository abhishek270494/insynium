package java.services;

import java.model.Document;
import java.model.Part;

import java.util.Set;

/**
 * Interface for specific part service operations.
 * Extends the CommonOperation interface to inherit java.common operations.
 */
public interface IPartService extends EntityService {

    Set<Document> getLinkedDocuments(Part part);
}
