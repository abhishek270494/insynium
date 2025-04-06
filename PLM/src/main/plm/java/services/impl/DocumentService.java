package java.services.impl;

import java.dao.DocumentDao;
import java.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.services.IDocumentService;

@Service
@Transactional
public class DocumentService extends CommonOperations implements IDocumentService {

    @Autowired
    private DocumentDao documentDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentService.class);

    @Override
    public void reserve(String userId, String reference, String version, int iteration) {
        Document document = documentDao.get(reference, version, iteration);
        documentDao.create(mapReservedDocument(userId, iteration, document));
    }

    @Override
    public void update(String userId, String reference, String version, int iteration, String documentAttribute1, String documentAttribute2) {
        Document document = documentDao.get(reference, version, iteration);
        document.setDocumentAttribute1(documentAttribute1);
        document.setDocumentAttribute2(documentAttribute2);
        documentDao.update(document);
    }

    @Override
    public void free(String userId, String reference, String version, int iteration) {
        Document document = documentDao.get(reference, version, iteration);
        if (isNotLinkedToPart(document)) {
            document.setReserved(false);
            document.setReservedBy(null);
            documentDao.update(document);
        }
    }

    @Override
    public void setState(String userId, String reference, String version, int iteration, String state) throws RuntimeException {
        Document document = documentDao.get(reference, version, iteration);
        document.setLifeCycleState(state);
        documentDao.update(document);
    }

    @Override
    public void revise(String userId, String reference, String version, int iteration) throws RuntimeException {
        Document document = documentDao.get(reference, version, iteration);
        documentDao.create(mapRevisedDocument(version, document));
    }

    @Override
    public boolean isNotLinkedToPart(Document document) {
        //
        // Implementation and returned value are not relevant for this exercise
        //
        return false;
    }
}
