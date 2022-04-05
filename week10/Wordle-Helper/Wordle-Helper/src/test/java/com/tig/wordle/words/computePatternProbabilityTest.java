package com.tig.wordle.words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;

public class computePatternProbabilityTest {

    private WordService underTest;

    @BeforeEach
    void setup() {
        WordDAO mockWordDAO = mock(WordDAO.class);
        this.underTest = new WordService(mockWordDAO);
    }

    @Test
    void returnsCorrectValue() {
        // Given
        Word guess1 = new Word(1, "tacit", 0.25, 1.0 );
        Word guess2 = new Word(1, "horse", 0.25, 1.0 );
        Word guess3 = new Word(1, "raven", 0.25, 1.0 );
        Word guess4 = new Word(1, "grass", 0.25, 1.0 );
        List<Word> wordList = new ArrayList<>();
        wordList.add(guess1);
        wordList.add(guess2);
        wordList.add(guess3);
        wordList.add(guess4);
        LinkedHashMap<String, String> pattern = new LinkedHashMap<>();
        pattern.put("r0", "yellow");
        pattern.put("a1", "grey");
        pattern.put("v2", "grey");
        pattern.put("e3", "yellow");
        pattern.put("n4", "grey");
        // When
        Double actual = underTest.computePatternProbability(guess3, wordList, pattern);
        // Then
        Double expected = 0.25;
        assertThat(actual).isEqualTo(expected);
    }



}
