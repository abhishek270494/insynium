package java.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.services.impl.PartService;

/**
 * REST controller for managing parts.
 */
@RestController
@Tag(name = "Part Controller", description = "APIs for managing Part lifecycle")
public class PartController extends AbstractController {

    @Autowired
    private PartService partService;

    /**
     * Endpoint to reserve a part.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the part
     * @param version   the version of the part
     * @param iteration the iteration of the part
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Reserve a Part")
    public ResponseEntity<Void> reserve(String userId,
                                        String reference,
                                        String version,
                                        int iteration) {
        partService.reserve(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to update a part.
     *
     * @param userId         the ID of the user making the request
     * @param reference      the reference of the part
     * @param version        the version of the part
     * @param iteration      the iteration of the part
     * @param partAttribute1 the first attribute of the part
     * @param partAttribute2 the second attribute of the part
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Update a Part")
    public ResponseEntity<Void> update(String userId,
                                       String reference,
                                       String version,
                                       int iteration,
                                       @RequestParam("partAttribute1") String partAttribute1,
                                       @RequestParam("partAttribute2") String partAttribute2) {
        partService.update(userId, reference, version, iteration, partAttribute1, partAttribute2);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to free a part.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the part
     * @param version   the version of the part
     * @param iteration the iteration of the part
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Free a Part")
    public ResponseEntity<Void> free(String userId,
                                     String reference,
                                     String version,
                                     int iteration) {
        partService.free(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to set the state of a part.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the part
     * @param version   the version of the part
     * @param iteration the iteration of the part
     * @param state     the new state of the part
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Set Part state")
    public ResponseEntity<Void> setState(String userId,
                                         String reference,
                                         String version,
                                         int iteration,
                                         @RequestParam("state") String state) {
        partService.setState(userId, reference, version, iteration, state);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to revise a part.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the part
     * @param version   the version of the part
     * @param iteration the iteration of the part
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Revise a Part")
    public ResponseEntity<Void> revise(String userId,
                                       String reference,
                                       String version,
                                       int iteration) {
        partService.revise(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

}
