package com.tig.wordle.answers;

import com.tig.wordle.user.User;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAllAnswers();
    Answer getAnswerById(Integer id);
    Integer addAnswerToTable(Answer answer);
    Integer deleteAnswerById(Integer id);
    Integer updateAnswerById(Integer id, Answer answer);
}
