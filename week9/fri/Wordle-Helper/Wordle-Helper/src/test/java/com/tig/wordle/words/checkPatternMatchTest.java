package com.tig.wordle.words;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class checkPatternMatchTest {

    @Test
    void checkPatternMatch() {
        // Given
        WordDAO mockWordDAO = mock(WordDAO.class);
        WordService underTest = new WordService(mockWordDAO);

        // Generate test word
        Word word = new Word(1, "tares", 0.1, 1.1);
        // Generate test targetWord
        Word targetWord = new Word(2, "tolls", 0.1, 1.1);

//        LinkedHashMap<String, String> pattern = underTest.generateWordPattern(word,targetWord);

        LinkedHashMap<String, String> pattern = new LinkedHashMap<>();
        pattern.put("t0","green");
        pattern.put("a1","grey");
        pattern.put("r2","grey");
        pattern.put("e3","grey");
        pattern.put("s4","green");


        // When

        Boolean actual = underTest.checkPatternMatch(word, targetWord, pattern);

        // Then
        Boolean expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkPatternMatchIfFalse() {
        // Given
        WordDAO mockWordDAO = mock(WordDAO.class);
        WordService underTest = new WordService(mockWordDAO);

        // Generate test word
        Word word = new Word(1, "tares", 0.1, 1.1);
        // Generate test targetWord
        Word targetWord = new Word(2, "apple", 0.1, 1.1);

//        LinkedHashMap<String, String> pattern = underTest.generateWordPattern(word,targetWord);

        LinkedHashMap<String, String> pattern = new LinkedHashMap<>();
        pattern.put("t0","green");
        pattern.put("a1","grey");
        pattern.put("r2","grey");
        pattern.put("e3","grey");
        pattern.put("s4","green");


        // When

        Boolean actual = underTest.checkPatternMatch(word, targetWord, pattern);

        // Then
        Boolean expected = false;
        assertThat(actual).isEqualTo(expected);
    }

}