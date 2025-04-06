package plm.services;

import plm.model.Document;
import plm.model.Part;

import java.util.Set;

/**
 * Interface for specific part service operations.
 * Extends the CommonOperation interface to inherit common operations.
 */
public interface IPartService extends EntityService {

    Set<Document> getLinkedDocuments(Part part);
}
