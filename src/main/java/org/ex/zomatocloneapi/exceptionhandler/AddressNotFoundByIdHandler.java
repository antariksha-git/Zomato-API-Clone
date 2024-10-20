package org.ex.zomatocloneapi.exceptionhandler;

import org.ex.zomatocloneapi.exception.AddressNotFoundByIdException;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddressNotFoundByIdHandler {

    @ExceptionHandler(AddressNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleAddressNotFoundByIdException(AddressNotFoundByIdException e) {
        return AppResponseBuilder.error(HttpStatus.NOT_FOUND, "Address not found", e.getMessage());
    }
}
