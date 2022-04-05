package com.tig.wordle.words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;

class ComputeScoreDistributionTest {

    private WordService underTest;

    @BeforeEach
    void setup() {
        WordDAO mockWordDAO = mock(WordDAO.class);
        this.underTest = new WordService(mockWordDAO);
    }

    @Test
    void computeScoreDistribution() {
        // Given
        Word guess1 = new Word(1, "mouse", 0.25, 1.0 );
        Word guess2 = new Word(1, "pears", 0.25, 1.0 );
        Word guess3 = new Word(1, "pairs", 0.25, 1.0 );
        Word guess4 = new Word(1, "glass", 0.25, 1.0 );
        List<Word> wordList = new ArrayList<>();
        wordList.add(guess1);
        wordList.add(guess2);
        wordList.add(guess3);
        wordList.add(guess4);

        //When
        List<Word> actual = underTest.computeScoreDistribution(wordList);

        //Then
        Word expected1 = new Word(1, "mouse", 0.25, 2.0 );
        Word expected2 = new Word(1, "pears", 0.25, 2.0 );
        Word expected3 = new Word(1, "pairs", 0.25, 2.0 );
        Word expected4 = new Word(1, "glass", 0.25, 2.0 );
        List<Word> expectedwordList = new ArrayList<>();
        expectedwordList.add(expected1);
        expectedwordList.add(expected2);
        expectedwordList.add(expected3);
        expectedwordList.add(expected4);

        assertThat(actual).isEqualTo(expectedwordList);

    }
}