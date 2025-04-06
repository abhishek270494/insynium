package java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class AbstractController {

    @PostMapping("/Part/reserve")
    public abstract ResponseEntity<Void> reserve(@RequestHeader("userId") String userId,
                                                 @RequestParam("reference") String reference,
                                                 @RequestParam("version") String version,
                                                 @RequestParam("iteration") int iteration);

    @PutMapping("/Part/update")
    public abstract ResponseEntity<Void> update(@RequestHeader("userId") String userId,
                                                @RequestParam("reference") String reference,
                                                @RequestParam("version") String version,
                                                @RequestParam("iteration") int iteration,
                                                @RequestParam("partAttribute1") String partAttribute1,
                                                @RequestParam("partAttribute2") String partAttribute2);

    @PutMapping("/Part/free")
    public abstract ResponseEntity<Void> free(@RequestHeader("userId") String userId,
                                              @RequestParam("reference") String reference,
                                              @RequestParam("version") String version,
                                              @RequestParam("iteration") int iteration);


    @PutMapping("/Part/setState")
    public abstract ResponseEntity<Void> setState(@RequestHeader("userId") String userId,
                                                  @RequestParam("reference") String reference,
                                                  @RequestParam("version") String version,
                                                  @RequestParam("iteration") int iteration,
                                                  @RequestParam("state") String state);


    @PostMapping("/Part/revise")
    public abstract ResponseEntity<Void> revise(@RequestHeader("userId") String userId,
                                                @RequestParam("reference") String reference,
                                                @RequestParam("version") String version,
                                                @RequestParam("iteration") int iteration);
}
