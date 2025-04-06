package java.services;


import java.model.Document;

/**
 * Interface for specific document service operations.
 */
public interface IDocumentService extends IReservationService, IUpdateService,
        IReviseService, IStateService, IFreeService {

    boolean isNotLinkedToPart(Document document);

}
