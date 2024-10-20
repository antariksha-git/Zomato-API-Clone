package org.ex.zomatocloneapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantNotFoundById extends RuntimeException {

    private String message;

}
