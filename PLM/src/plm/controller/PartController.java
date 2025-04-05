package plm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plm.services.impl.PartService;

/**
 * REST controller for managing parts.
 */
@RestController
public class PartController {

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
    @PostMapping("/Part/reserve")
    public ResponseEntity<Void> reserve(@RequestHeader("userId") String userId,
                                        @RequestParam("reference") String reference,
                                        @RequestParam("version") String version,
                                        @RequestParam("iteration") int iteration) {
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
    @PutMapping("/Part/update")
    public ResponseEntity<Void> update(@RequestHeader("userId") String userId,
                                       @RequestParam("reference") String reference,
                                       @RequestParam("version") String version,
                                       @RequestParam("iteration") int iteration,
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
    @PutMapping("/Part/free")
    public ResponseEntity<Void> free(@RequestHeader("userId") String userId,
                                     @RequestParam("reference") String reference,
                                     @RequestParam("version") String version,
                                     @RequestParam("iteration") int iteration) {
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
    @PutMapping("/Part/setState")
    public ResponseEntity<Void> setState(@RequestHeader("userId") String userId,
                                         @RequestParam("reference") String reference,
                                         @RequestParam("version") String version,
                                         @RequestParam("iteration") int iteration,
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
    @PostMapping("/Part/revise")
    public ResponseEntity<Void> revise(@RequestHeader("userId") String userId,
                                       @RequestParam("reference") String reference,
                                       @RequestParam("version") String version,
                                       @RequestParam("iteration") int iteration) {
        partService.revise(userId, reference, version, iteration);
        return ResponseEntity.ok().build();
    }

}
