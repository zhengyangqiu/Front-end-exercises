package com.tig.wordle.user;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InputMissingException extends RuntimeException {
    public InputMissingException(String message) {
        super(message);
    }
}
