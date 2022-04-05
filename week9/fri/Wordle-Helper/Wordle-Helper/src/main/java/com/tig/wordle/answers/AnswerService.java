package com.tig.wordle.answers;

import com.tig.wordle.user.InputMissingException;
import com.tig.wordle.user.User;
import com.tig.wordle.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private AnswerDAO answerDAO;
    public AnswerService(@Qualifier("answer") AnswerDAO answerDAO){
        this.answerDAO = answerDAO;
    }

    public List<Answer> getAllAnswers(){
        return answerDAO.getAllAnswers();
    }

    public Boolean doesAnswerWithIdExists(Integer id) {
        return answerDAO
                .getAllAnswers()
                .stream()
                .anyMatch(p -> p.getId().equals(id));  // returns boolean
    }

    public Answer getAnswerById(Integer id){
        boolean exists = doesAnswerWithIdExists(id);
        if (exists == false) {
            throw new AnswerNotFoundException("Answer with ID " + id + " does not exist");
        }
        return answerDAO.getAnswerById(id);
    }

    public Integer addAnswerToTable(Answer answer){
        // Get the current answers from the table
        List<Answer> currentAnswers = getAllAnswers();
        // Empty list for the dates
        List<LocalDate> dates = new ArrayList<>();
        // Fill list of dates
        for (int i = 0; i < currentAnswers.size(); i++) {
            dates.add(currentAnswers.get(i).getDateOfAnswer());
        }
        // Check if our new answer date is included in current list of dates
        if (dates.contains(answer.getDateOfAnswer())){
            throw new AnswerDateTakenException("Could not add answer to table as given date already exists");
        }

        if (answer.getAnswerOfDay() != null
                && answer.getDateOfAnswer() != null
                && answer.getMachineResult() != null
                && answer.getAnswerOfDay() != "") {
            return answerDAO.addAnswerToTable(answer);
        } else throw new InputMissingException("Invalid entry. Fields cannot be empty");

    }

    public Integer deleteAnswerById(Integer id) {
        getAnswerById(id);
        return answerDAO.deleteAnswerById(id);
    }

    public Integer updateAnswerById(Integer id, Answer answer) {
        getAnswerById(id);
        if (answer.getAnswerOfDay() != null
                && answer.getDateOfAnswer() != null
                && answer.getMachineResult() != null
                && answer.getAnswerOfDay() != "") {
            return answerDAO.updateAnswerById(id, answer);
        } else throw new InputMissingException("Invalid entry. Fields cannot be empty");

    }
}
