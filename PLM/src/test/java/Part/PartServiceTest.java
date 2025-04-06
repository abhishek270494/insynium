package Part;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.dao.PartDao;
import java.model.Part;
import java.services.impl.PartService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the PartService class.
 */
public class PartServiceTest {

    @Autowired
    private PartDao partDao;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PartService partService;

    /**
     * Tests that a part is reserved correctly.
     */
    @Test
    void testReservePart() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;

        partService.reserve(userId, reference, version, iteration);

        Part part = partDao.get(reference, version, iteration);
        assertTrue(part.isReserved());
    }

    /**
     * Tests that part attributes are updated correctly.
     */
    @Test
    void testPartAttributes() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;
        String attribute1 = "attr1";
        String attribute2 = "attr2";

        partService.update(userId, reference, version, iteration, attribute1, attribute2);

        Part part = partDao.get(reference, version, iteration);
        assertEquals(attribute1, part.getPartAttribute1());
        assertEquals(attribute2, part.getPartAttribute2());
    }

    /**
     * Tests that a part is freed correctly if it is reserved by the user.
     */
    @Test
    void testFreeReservedByUser() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;
        Part part = new Part();
        part.setReserved(true);
        part.setReservedBy(userId);
        partDao.create(part);

        partService.free(userId, reference, version, iteration);

        part = partDao.get(reference, version, iteration);
        assertFalse(part.isReserved());
        assertNull(part.getReservedBy());
    }

    /**
     * Tests that the state of a part is set correctly.
     */
    @Test
    void testPartState() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;
        String state = "newState";

        partService.setState(userId, reference, version, iteration, state);

        Part part = partDao.get(reference, version, iteration);
        assertEquals(state, part.getLifeCycleState());
    }

    /**
     * Tests that a revised part is created correctly.
     */
    @Test
    void testRevisedPart() {
        String userId = "user1";
        String reference = "ref1";
        String version = "v1";
        int iteration = 1;

        partService.revise(userId, reference, version, iteration);

        Part part = partDao.get(reference, version, iteration);
        assertNotNull(part);
    }
}
