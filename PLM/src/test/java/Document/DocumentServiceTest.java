package Document;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.dao.DocumentDao;
import java.model.Document;
import java.services.impl.DocumentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the DocumentService class.
 */
public class DocumentServiceTest {

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private DocumentService documentService;

    /**
     * Tests that a document is reserved correctly.
     */
    @Test
    void testReserveDocument() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;

        documentService.reserve(userId, reference, version, iteration);

        Document document = documentDao.get(reference, version, iteration);
        assertTrue(document.isReserved());
    }

    /**
     * Tests that document attributes are updated correctly.
     */
    @Test
    void testUpdateDocumentAttributes() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;
        String documentAttribute1 = "attr1";
        String documentAttribute2 = "attr2";

        documentService.update(userId, reference, version, iteration, documentAttribute1, documentAttribute2);

        Document document = documentDao.get(reference, version, iteration);
        assertEquals(documentAttribute1, document.getDocumentAttribute1());
        assertEquals(documentAttribute2, document.getDocumentAttribute2());
    }

    /**
     * Tests that a document is freed correctly if it is not linked to a part.
     */
    @Test
    void testFreeDocumentIfNotLinkedToPart() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;

        documentService.free(userId, reference, version, iteration);

        Document document = documentDao.get(reference, version, iteration);
        assertFalse(document.isReserved());
        assertNull(document.getReservedBy());
    }

    /**
     * Tests that the state of a document is set correctly.
     */
    @Test
    void testSetDocumentState() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;
        String state = "newState";

        documentService.setState(userId, reference, version, iteration, state);

        Document document = documentDao.get(reference, version, iteration);
        assertEquals(state, document.getLifeCycleState());
    }

    /**
     * Tests that a revised document is created correctly.
     */
    @Test
    void testRevisedDocument() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;

        documentService.revise(userId, reference, version, iteration);

        Document document = documentDao.get(reference, version, iteration);
        assertNotNull(document);
    }
}
