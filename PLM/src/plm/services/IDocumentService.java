package plm.services;

import plm.model.Document;

/**
 * Interface for specific document service operations.
 * Extends the CommonOperation interface to inherit common operations.
 */
public interface IDocumentService extends EntityService {

    boolean isNotLinkedToPart(Document document);

}
