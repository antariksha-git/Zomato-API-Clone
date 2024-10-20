package org.ex.zomatocloneapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AppResponseBuilder {
   public static <T>ResponseEntity<ResponseStructure<T>> create(HttpStatus status, String message, T data) {
       return ResponseEntity
               .status(status)
               .body(ResponseStructure.create(status, message, data));
   }

    public static ResponseEntity<ErrorStructure<String>> error(HttpStatus status, String message, String rootCause) {
        return ResponseEntity
                .status(status)
                .body(ErrorStructure.getErrorStructure(status, message, rootCause));
    }
}
