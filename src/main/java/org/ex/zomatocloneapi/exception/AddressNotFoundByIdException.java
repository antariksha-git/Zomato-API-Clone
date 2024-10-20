package org.ex.zomatocloneapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddressNotFoundByIdException extends RuntimeException {
    private String message;
}
