package org.ex.zomatocloneapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantNotFoundByIdException extends RuntimeException {

    private String message;

}
