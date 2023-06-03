package ru.Irina.ComputerStore.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import java.util.List;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    private record ExceptionResponse(List<String> errors) {
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse catchResourceNotFoundException(final ResourceNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return new ExceptionResponse(List.of(ex.getMessage()));
    }

    @ExceptionHandler(value = IllegalArgException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse catchIllegalArgumentException(final IllegalArgException ex) {
        log.error(ex.getMessage(), ex);
        return new ExceptionResponse(List.of(ex.getMessage()));
    }
}
