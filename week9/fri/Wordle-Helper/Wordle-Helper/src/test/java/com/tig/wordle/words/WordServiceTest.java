package com.tig.wordle.words;

import com.tig.wordle.answers.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class WordServiceTest {
    private WordService underTest;
    private WordDAO wordDAO;

    @BeforeEach
    void setUp(){
        this.wordDAO = Mockito.mock(WordDAO.class);
        this.underTest = new WordService(wordDAO);
    }

    @Test
    void testGetAllRankedByScore(){
        // Given
        Word testWord1 = new Word(1, "hello", 0.25, 2.0);
        Word testWord2 = new Word(2, "image", 0.25, 1.0);
        Word testWord3 = new Word(3, "opens", 0.25, 0.5);
        Word testWord4 = new Word(4, "fares", 0.25, 0.25);
        List<Word> wordsOrderedByScore = new ArrayList<>();
        wordsOrderedByScore.add(testWord1);
        wordsOrderedByScore.add(testWord2);
        wordsOrderedByScore.add(testWord3);
        wordsOrderedByScore.add(testWord4);
        given(wordDAO.selectAllWordsRankedByScore()).willReturn(wordsOrderedByScore);
        // When
        List<Word> actual = underTest.getAllWordsRankedByScore();
        // Then
        List<Word> expected = wordsOrderedByScore;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAllWords() {
        // Given
        Word testWord1 = new Word(1, "hello", 0.25, 2.0);
        Word testWord2 = new Word(2, "image", 0.25, 1.0);
        Word testWord3 = new Word(3, "opens", 0.25, 0.5);
        Word testWord4 = new Word(4, "fares", 0.25, 0.25);
        List<Word> allWords = new ArrayList<>();
        allWords.add(testWord1);
        allWords.add(testWord2);
        allWords.add(testWord3);
        allWords.add(testWord4);
        given(wordDAO.selectAllWords()).willReturn(allWords);
        // When
        List<Word> actual = underTest.getAllWords();
        // Then
        List<Word> expected = allWords;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canGetWordById() {
        // Given
        Word testWord1 = new Word(1, "hello", 0.25, 2.0);
        Word testWord2 = new Word(2, "image", 0.25, 1.0);
        Word testWord3 = new Word(3, "opens", 0.25, 0.5);
        Word testWord4 = new Word(4, "fares", 0.25, 0.25);
        List<Word> allWords = new ArrayList<>();
        allWords.add(testWord1);
        allWords.add(testWord2);
        allWords.add(testWord3);
        allWords.add(testWord4);
        given(wordDAO.selectWordById(1)).willReturn(testWord1);

        // When
        Word actual = underTest.getWordById(1);

        //Then
        Word expected = testWord1;
        assertThat(actual).isEqualTo(expected);

    }
    @Test
    void canGetWordByName() {
        // Given
        Word testWord1 = new Word(1, "hello", 0.25, 2.0);
        Word testWord2 = new Word(2, "image", 0.25, 1.0);
        Word testWord3 = new Word(3, "opens", 0.25, 0.5);
        Word testWord4 = new Word(4, "fares", 0.25, 0.25);
        List<Word> allWords = new ArrayList<>();
        allWords.add(testWord1);
        allWords.add(testWord2);
        allWords.add(testWord3);
        allWords.add(testWord4);
        given(wordDAO.selectWordByName("hello")).willReturn(testWord1);

        // When
        Word actual = underTest.getWordByName("hello");

        //Then
        Word expected = testWord1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canGetTopWords() {
        // Given
        Word testWord1 = new Word(1, "hello", 0.25, 2.0);
        Word testWord2 = new Word(2, "image", 0.25, 1.0);
        Word testWord3 = new Word(3, "opens", 0.25, 0.5);
        Word testWord4 = new Word(4, "fares", 0.25, 0.25);
        List<Word> allWords = new ArrayList<>();
        allWords.add(testWord1);
        allWords.add(testWord2);
        allWords.add(testWord3);
        allWords.add(testWord4);


        List<Word> topThreeWords = new ArrayList<>();
        topThreeWords.add(testWord1);
        topThreeWords.add(testWord2);
        topThreeWords.add(testWord3);

        given(wordDAO.selectTopWords(3)).willReturn(topThreeWords);

        // When
        List<Word> actual = underTest.getTopWords(3);

        //Then

        List<Word> expected = topThreeWords;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void wordValidatorReturnsTrueWhenWordIsValid(){
        // Given
        Word testWord1 = new Word(1, "hello", 0.25, 2.0);
        Word testWord2 = new Word(2, "image", 0.25, 1.0);
        Word testWord3 = new Word(3, "opens", 0.25, 0.5);
        Word testWord4 = new Word(4, "fares", 0.25, 0.25);
        List<Word> allWords = new ArrayList<>();
        allWords.add(testWord1);
        allWords.add(testWord2);
        allWords.add(testWord3);
        allWords.add(testWord4);
        given(wordDAO.selectAllWords()).willReturn(allWords);
        String testString = "hello";
        // When
        Boolean actual = underTest.wordValidator(testString);
        // Then
        assertThat(actual).isTrue();
    }
    @Test
    void wordValidatorThrowsException(){
        // Given
        Word testWord1 = new Word(1, "hello", 0.25, 2.0);
        Word testWord2 = new Word(2, "image", 0.25, 1.0);
        Word testWord3 = new Word(3, "opens", 0.25, 0.5);
        Word testWord4 = new Word(4, "fares", 0.25, 0.25);
        List<Word> allWords = new ArrayList<>();
        allWords.add(testWord1);
        allWords.add(testWord2);
        allWords.add(testWord3);
        allWords.add(testWord4);
        given(wordDAO.selectAllWords()).willReturn(allWords);
        String testString = "tacit";

        // Then
        assertThatThrownBy(() -> {
            // When
            underTest.wordValidator(testString);}
        ).hasMessage("Invalid Entry. Word is not in word list");
    }

    //check test - why doesnt it work for bonds/anger but works for birds??
    @Test
    void testCanGetGuessesForAnswer(){
        // Given
        Answer answerTest = new Answer();
        answerTest.setAnswerOfDay("anger");
        List<Word> mockWordList = new ArrayList<>();
        Word mockWord3 = new Word(1, "anger", 0.25, 1.5);
        Word mockWord4 = new Word(2, "troll", 0.25, 1.5);
        Word mockWord2 = new Word(3, "birds", 0.25, 1.5);
        Word mockWord1 = new Word(4, "bonds", 0.25, 2.0);
        mockWordList.add(mockWord1);
        mockWordList.add(mockWord2);
        mockWordList.add(mockWord3);
        mockWordList.add(mockWord4);
        given(wordDAO.selectAllWordsRankedByScore()).willReturn(mockWordList);
        given(wordDAO.selectWordByName(answerTest.getAnswerOfDay())).willReturn(mockWord3);
        // When
        Answer actual = underTest.getGuessesForAnswer(answerTest);
        // Then
        Integer expected = 2;
        assertThat(actual.getMachineResult()).isEqualTo(expected);
    }
}
