package com.tig.wordle.games;

import java.util.Objects;

public class Game {
    private Integer id;
    private Integer userId;
    private Integer answerId;
    private Integer userGuesses;

    public Game(){

    }
    public Game(Integer id, Integer userId, Integer answerId, Integer userGuesses) {
        this.id = id;
        this.userId = userId;
        this.answerId = answerId;
        this.userGuesses = userGuesses;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getUserGuesses() {
        return userGuesses;
    }

    public void setUserGuesses(Integer userGuesses) {
        this.userGuesses = userGuesses;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", userId=" + userId +
                ", answerId=" + answerId +
                ", userGuesses=" + userGuesses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(userId, game.userId) && Objects.equals(answerId, game.answerId) && Objects.equals(userGuesses, game.userGuesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, answerId, userGuesses);
    }
}
