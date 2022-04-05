package com.tig.wordle.words;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SetUniformProbabilityTest {

    @Test
    void setUniformProbabilities() {
        WordDAO mockWordDAO = mock(WordDAO.class);

        //Given
        WordService underTest = new WordService(mockWordDAO);
        Word word1 = new Word();
        Word word2 = new Word();
        Word word3 = new Word();
        Word word4 = new Word();
        List<Word> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        //When
        List<Word> actual = underTest.setUniformProbabilities(words);
        Double actualProbability = words.get(1).getProbability();


        //Then
        Double expectedProbability = 0.25;

        assertThat(actualProbability).isEqualTo(expectedProbability);


    }
}