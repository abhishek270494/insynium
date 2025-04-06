package java.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.services.impl.DocumentService;

/**
 * REST controller for managing documents.
 */
@RestController
@Tag(name = "Document Controller", description = "APIs for managing Document lifecycle")
public class DocumentController extends AbstractController {

    @Autowired
    private DocumentService documentService;

    /**
     * Endpoint to reserve a document.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the document
     * @param version   the version of the document
     * @param iteration the iteration of the document
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Reserve a Document")
    public ResponseEntity<Void> reserve(String userId,
                                        String reference,
                                        String version,
                                        int iteration) {
        documentService.reserve(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to update a document.
     *
     * @param userId             the ID of the user making the request
     * @param reference          the reference of the document
     * @param version            the version of the document
     * @param iteration          the iteration of the document
     * @param documentAttribute1 the first attribute of the document
     * @param documentAttribute2 the second attribute of the document
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Update a Document")
    public ResponseEntity<Void> update(String userId,
                                       String reference,
                                       String version,
                                       int iteration,
                                       String documentAttribute1,
                                       String documentAttribute2) {
        documentService.update(userId, reference, version, iteration, documentAttribute1, documentAttribute2);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to free a document.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the document
     * @param version   the version of the document
     * @param iteration the iteration of the document
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Free a Document")
    public ResponseEntity<Void> free(String userId,
                                     String reference,
                                     String version,
                                     int iteration) {
        documentService.free(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to set the state of a document.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the document
     * @param version   the version of the document
     * @param iteration the iteration of the document
     * @param state     the new state of the document
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Set Document state")
    public ResponseEntity<Void> setState(String userId,
                                         String reference,
                                         String version,
                                         int iteration,
                                         String state) {
        documentService.setState(userId, reference, version, iteration, state);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint to revise a document.
     *
     * @param userId    the ID of the user making the request
     * @param reference the reference of the document
     * @param version   the version of the document
     * @param iteration the iteration of the document
     * @return a ResponseEntity indicating the result of the operation
     */
    @Override
    @Operation(summary = "Revise a Document")
    public ResponseEntity<Void> revise(String userId,
                                       String reference,
                                       String version,
                                       int iteration) {
        documentService.revise(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

}
