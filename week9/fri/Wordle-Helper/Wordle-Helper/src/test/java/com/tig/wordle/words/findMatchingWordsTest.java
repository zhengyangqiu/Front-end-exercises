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

class findMatchingWordsTest {

    @Test
    void canFindRemainingPossibleGuesses() {
        WordDAO mockWordDAO = mock(WordDAO.class);

        // Given
        WordService underTest = new WordService(mockWordDAO);

        // Generate test word
        Word guess = new Word(1, "tares", 0.1, 1.1);
        // Generate test targetWord
        Word targetWord = new Word(2, "tolls", 0.1, 1.1);

        Word listWord1 = new Word(2, "tolls", 0.1, 1.1);
        Word listWord2 = new Word(3, "tools", 0.1, 1.1);
        Word listWord3 = new Word(4, "house", 0.1, 1.1);
        Word listWord4 = new Word(5, "spoon", 0.1, 1.1);

        List<Word> fullWordList = new ArrayList<>();

        fullWordList.add(listWord1);
        fullWordList.add(listWord2);
        fullWordList.add(listWord3);
        fullWordList.add(listWord4);

        LinkedHashMap<String, String> pattern = underTest.generateWordPattern(guess,targetWord);

        // When
        List<Word> actual = underTest.findMatchingWords(guess, fullWordList,pattern);

        // Then
        List<Word> expected = new ArrayList<>();
        expected.add(listWord1); // only possible words are tolls and tools
        expected.add(listWord2);


        assertThat(actual).isEqualTo(expected);
    }

}