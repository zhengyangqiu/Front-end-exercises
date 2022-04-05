package com.tig.wordle.answers;

import java.time.LocalDate;
import java.util.Objects;

public class Answer {
    private Integer id;
    private LocalDate dateOfAnswer;
    private String answerOfDay;
    private Integer machineResult;

    public Answer(){

    }
    public Answer(Integer id, LocalDate dateOfAnswer, String answerOfDay, Integer machineResult) {
        this.id = id;
        this.dateOfAnswer = dateOfAnswer;
        this.answerOfDay = answerOfDay;
        this.machineResult = machineResult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOfAnswer() {
        return dateOfAnswer;
    }

    public void setDateOfAnswer(LocalDate dateOfAnswer) {
        this.dateOfAnswer = dateOfAnswer;
    }

    public String getAnswerOfDay() {
        return answerOfDay;
    }

    public void setAnswerOfDay(String answerOfDay) {
        this.answerOfDay = answerOfDay;
    }

    public Integer getMachineResult() {
        return machineResult;
    }

    public void setMachineResult(Integer machineResult) {
        this.machineResult = machineResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(dateOfAnswer, answer.dateOfAnswer) && Objects.equals(answerOfDay, answer.answerOfDay) && Objects.equals(machineResult, answer.machineResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfAnswer, answerOfDay, machineResult);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", dateOfAnswer=" + dateOfAnswer +
                ", answerOfDay='" + answerOfDay + '\'' +
                ", machineResult=" + machineResult +
                '}';
    }
}
