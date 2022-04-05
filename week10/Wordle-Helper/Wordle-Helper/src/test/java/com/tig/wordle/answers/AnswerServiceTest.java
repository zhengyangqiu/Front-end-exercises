package com.tig.wordle.answers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class AnswerServiceTest {
    private AnswerService underTest;
    private AnswerDAO answerDAO;

    @BeforeEach
    void setUp(){
        this.answerDAO = Mockito.mock(AnswerDAO.class);
        this.underTest = new AnswerService(answerDAO);
    }

    @Test
    void getAllAnswers() {
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 21), "grass", 3);
        Answer answer3 = new Answer(3, LocalDate.of(2019, 1, 22), "horse", 4);

        // Placeholder for list
        List<Answer> answerList = new ArrayList<>();
        // Add to list
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        // Given
        given(answerDAO.getAllAnswers()).willReturn(answerList);
        // When
        List<Answer> actual = underTest.getAllAnswers();
        // Then
        List<Answer> expected = answerList;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAnswerById() {
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 21), "grass", 3);
        Answer answer3 = new Answer(3, LocalDate.of(2019, 1, 22), "horse", 4);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        given(answerDAO.getAllAnswers()).willReturn(answerList);

        // Given
        given(answerDAO.getAnswerById(2)).willReturn(answer2);
        // When
        Answer actual = underTest.getAnswerById(2);
        // Then
        Answer expected = answer2;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowExceptionWhenGettingAnswerById() {
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 21), "grass", 3);
        Answer answer3 = new Answer(3, LocalDate.of(2019, 1, 22), "horse", 4);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        given(answerDAO.getAllAnswers()).willReturn(answerList);

        assertThatThrownBy(() -> {
            underTest.getAnswerById(20);}
        ).hasMessage("Answer with ID 20 does not exist");

    }

    // Test Exception for this, if time!
    @Test
    void addAnswerToTable() {
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);



        // Given
        given(answerDAO.addAnswerToTable(answer1)).willReturn(1);
        // When
        Integer actual = underTest.addAnswerToTable(answer1);
        // Then
        Integer expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowExceptionWhenaddingAnswerToTable() {

        Answer answer1 = new Answer(4, LocalDate.of(2019, 1, 23), "", 5);

        assertThatThrownBy(() -> {
            underTest.addAnswerToTable(answer1);}
        ).hasMessage("Invalid entry. Fields cannot be empty");

    }
    @Test
    void deleteAnswerById() {
        // Given
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 21), "grass", 3);
        Answer answer3 = new Answer(3, LocalDate.of(2019, 1, 22), "horse", 4);

        // Placeholder for list
        List<Answer> answerList = new ArrayList<>();
        // Add to list
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        given(answerDAO.getAllAnswers()).willReturn(answerList);

        given(answerDAO.getAnswerById(1)).willReturn(answer1);

        given(answerDAO.deleteAnswerById(1)).willReturn(1);

        // When
        Integer actual = underTest.deleteAnswerById(1);

        // Then
        Integer expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowExceptionWhenDeletingAnswerById() {
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 21), "grass", 3);
        Answer answer3 = new Answer(3, LocalDate.of(2019, 1, 22), "horse", 4);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        given(answerDAO.getAllAnswers()).willReturn(answerList);

        assertThatThrownBy(() -> {
            underTest.deleteAnswerById(4);}
        ).hasMessage("Answer with ID 4 does not exist");

    }

    @Test
    void updateAnswerById() {
        // Given
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 21), "grass", 3);
        Answer answer3 = new Answer(3, LocalDate.of(2019, 1, 22), "horse", 4);
        // New (updated) answer object
        Answer updatedAnswer = new Answer(3, LocalDate.of(2019, 1, 28), "tense", 2);

        // Placeholder for list
        List<Answer> answerList = new ArrayList<>();
        // Add to list
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        given(answerDAO.getAllAnswers()).willReturn(answerList);
        given(answerDAO.getAnswerById(3)).willReturn(answer3);
        given(answerDAO.updateAnswerById(3, updatedAnswer )).willReturn(1);
        // When
        Integer actual = underTest.updateAnswerById(3, updatedAnswer);
        // Then
        Integer expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowIDExceptionWhenUpdatingAnswerById() {
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 22), "horse", 4);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);

        Answer updatedanswer = new Answer(2, LocalDate.of(2019, 1, 21), "grass", 3);
        given(answerDAO.getAllAnswers()).willReturn(answerList);

        assertThatThrownBy(() -> {
            underTest.updateAnswerById(4, updatedanswer);}
        ).hasMessage("Answer with ID 4 does not exist");

    }

    @Test
    void canThrowMissingFieldsExceptionWhenUpdatingAnswerById() {
        // Create objects
        Answer answer1 = new Answer(1, LocalDate.of(2019, 1, 20), "glass", 2);
        Answer answer2 = new Answer(2, LocalDate.of(2019, 1, 22), "horse", 4);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);

        Answer updatedanswer = new Answer(2, LocalDate.of(2019, 1, 21), "", 3);
        given(answerDAO.getAllAnswers()).willReturn(answerList);

        assertThatThrownBy(() -> {
            underTest.updateAnswerById(1, updatedanswer);}
        ).hasMessage("Invalid entry. Fields cannot be empty");

    }
}

