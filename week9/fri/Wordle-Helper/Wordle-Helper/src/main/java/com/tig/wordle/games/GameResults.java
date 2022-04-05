package com.tig.wordle.games;

import java.util.Objects;

public class GameResults {
    private String actual_word;
    private String userName;
    private Integer guessesTaken;
    private Integer machineGuesses;

    public GameResults() {

    }


    public GameResults(String actual_word, String userName, Integer guessesTaken, Integer machineGuesses) {
        this.actual_word = actual_word;

        this.userName = userName;
        this.guessesTaken = guessesTaken;
        this.machineGuesses = machineGuesses;
    }

    public String getActual_word() {
        return actual_word;
    }

    public void setActual_word(String actual_word) {
        this.actual_word = actual_word;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGuessesTaken() {
        return guessesTaken;
    }

    public void setGuessesTaken(Integer guessesTaken) {
        this.guessesTaken = guessesTaken;
    }

    public Integer getMachineGuesses() {
        return machineGuesses;
    }

    public void setMachineGuesses(Integer machineGuesses) {
        this.machineGuesses = machineGuesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResults that = (GameResults) o;
        return Objects.equals(actual_word, that.actual_word) && Objects.equals(userName, that.userName) && Objects.equals(guessesTaken, that.guessesTaken) && Objects.equals(machineGuesses, that.machineGuesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actual_word, userName, guessesTaken, machineGuesses);
    }

    @Override
    public String toString() {
        return "GameResults{" +
                "actual_word='" + actual_word + '\'' +
                ", userName='" + userName + '\'' +
                ", guessesTaken=" + guessesTaken +
                ", machineGuesses=" + machineGuesses +
                '}';
    }
}