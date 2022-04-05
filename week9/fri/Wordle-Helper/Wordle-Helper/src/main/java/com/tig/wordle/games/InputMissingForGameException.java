package com.tig.wordle.games;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InputMissingForGameException extends RuntimeException {
    public InputMissingForGameException(String message) {
        super(message);
    }
}
