package org.ex.zomatocloneapi.exceptionhandler;

import org.ex.zomatocloneapi.exception.RestaurantNotFoundById;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantNotFoundByIdHandler {

    @ExceptionHandler(RestaurantNotFoundById.class)
    public ResponseEntity<ErrorStructure<String>> handleRestaurantNotFoundById(RestaurantNotFoundById e) {
        return AppResponseBuilder
                .error(HttpStatus.NOT_FOUND, "Restaurant Not Found by the given id", e.getMessage());
    }
}
