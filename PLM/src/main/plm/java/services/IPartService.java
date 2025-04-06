package java.services;

import java.model.Document;
import java.model.Part;

import java.util.Set;

/**
 * Interface for specific part service operations.
 */
public interface IPartService extends IReservationService, IUpdateService,
        IReviseService, IStateService, IFreeService {

    Set<Document> getLinkedDocuments(Part part);
}
