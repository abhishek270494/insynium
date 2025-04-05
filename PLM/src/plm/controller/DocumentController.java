package plm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plm.services.impl.DocumentService;

/**
 * REST controller for managing documents.
 */
@RestController
public class DocumentController {

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
    @GetMapping("/Document/reserve")
    public ResponseEntity<Void> reserve(@RequestHeader("userId") String userId,
                                        @RequestParam("reference") String reference,
                                        @RequestParam("version") String version,
                                        @RequestParam("iteration") int iteration) {
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
    @PutMapping("/Document/update")
    public ResponseEntity<Void> update(@RequestHeader("userId") String userId,
                                       @RequestParam("reference") String reference,
                                       @RequestParam("version") String version,
                                       @RequestParam("iteration") int iteration,
                                       @RequestParam("documentAttribute1") String documentAttribute1,
                                       @RequestParam("documentAttribute2") String documentAttribute2) {
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
    @PutMapping("/Document/free")
    public ResponseEntity<Void> free(@RequestHeader("userId") String userId,
                                     @RequestParam("reference") String reference,
                                     @RequestParam("version") String version,
                                     @RequestParam("iteration") int iteration) {
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
    @PutMapping("/Document/setState")
    public ResponseEntity<Void> setState(@RequestHeader("userId") String userId,
                                         @RequestParam("reference") String reference,
                                         @RequestParam("version") String version,
                                         @RequestParam("iteration") int iteration,
                                         @RequestParam("state") String state) {
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
    @PostMapping("/Document/revise")
    public ResponseEntity<Void> revise(@RequestHeader("userId") String userId,
                                       @RequestParam("reference") String reference,
                                       @RequestParam("version") String version,
                                       @RequestParam("iteration") int iteration) {
        documentService.revise(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

}
