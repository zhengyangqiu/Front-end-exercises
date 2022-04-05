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
import static org.mockito.Mockito.mock;

public class logTwoTest {

    private WordService underTest;

    @BeforeEach
    void setup() {
        WordDAO mockWordDAO = mock(WordDAO.class);
        this.underTest = new WordService(mockWordDAO);
    }

    @Test
    void returnsCorrectLogTwoValue() {
        // Given
        Double value = 8.0;
        // When
        Double actual = underTest.logTwo(value);
        // Then
        Double expected = 3.0;
        assertThat(actual).isEqualTo(expected);
    }
}


//     public Double logTwo(Double value){
//        return log(value)/log(2);
//    }
