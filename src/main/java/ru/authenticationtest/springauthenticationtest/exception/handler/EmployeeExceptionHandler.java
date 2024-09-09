package ru.authenticationtest.springauthenticationtest.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.authenticationtest.springauthenticationtest.exception.NotFoundException;


@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> ha(NotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(e.getMessage());
    }
}
