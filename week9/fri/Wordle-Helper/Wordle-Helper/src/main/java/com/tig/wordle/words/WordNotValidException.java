package com.tig.wordle.words;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WordNotValidException extends RuntimeException {
        public WordNotValidException(String message) {
            super(message);
        }
    }

