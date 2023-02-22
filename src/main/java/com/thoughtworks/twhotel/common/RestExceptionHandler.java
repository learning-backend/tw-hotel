package com.thoughtworks.twhotel.common;

import com.thoughtworks.twhotel.common.exception.BaseException;
import com.thoughtworks.twhotel.common.exception.ExceptionRepresentation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionRepresentation> handle(BaseException exception) {
        log.error("handle exception", exception);
        int statusCode = exception.getStatusCode();
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .message(exception.getMessage())
                .exceptionCode(exception.getExceptionCode())
                .parameters(exception.getParameters())
                .statusCode(statusCode)
                .build();
        return ResponseEntity.status(statusCode).body(representation);
    }
}
