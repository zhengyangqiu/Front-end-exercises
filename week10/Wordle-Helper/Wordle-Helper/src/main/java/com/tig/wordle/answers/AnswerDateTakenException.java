package com.tig.wordle.answers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnswerDateTakenException extends RuntimeException {
    public AnswerDateTakenException(String message) {
        super(message);
    }
}
