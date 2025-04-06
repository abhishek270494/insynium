package java.services;


import java.model.Document;

/**
 * Interface for specific document service operations.
 * Extends the CommonOperation interface to inherit java.common operations.
 */
public interface IDocumentService extends EntityService {

    boolean isNotLinkedToPart(Document document);

}
