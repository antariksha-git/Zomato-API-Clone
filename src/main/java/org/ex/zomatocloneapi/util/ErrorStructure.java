package org.ex.zomatocloneapi.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorStructure<T> {

    private int statusCode;
    private String message;
    private T rootCause;

    public static <T> ErrorStructure<T> getErrorStructure(HttpStatus statusCode, T rootCause, String message) {
        ErrorStructure<T> errorStructure = new ErrorStructure<>();
        errorStructure.setStatusCode(statusCode.value());
        errorStructure.setRootCause(rootCause);
        errorStructure.setMessage(message);

        return errorStructure;
    }
}

