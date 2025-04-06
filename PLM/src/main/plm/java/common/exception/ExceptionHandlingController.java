package java.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.common.dto.ServerErrorResponse;

/**
 * Centralized place for handling all generic and unexpected exceptions.
 */
@ControllerAdvice
public class ExceptionHandlingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(PlmTechnicalException.class)
    public ResponseEntity<ServerErrorResponse> handlePlmTechnicalException(PlmTechnicalException e) {
        LOGGER.error("Handle PlmTechnicalException", e);
        return ResponseEntity.ok(new ServerErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage()));
    }

}
