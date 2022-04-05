package com.tig.wordle.games;

import com.tig.wordle.answers.Answer;

import java.time.LocalDate;
import java.util.List;

public interface GameDAO {
    List<Game> getAllGames();
    Game getGameById(Integer id);
    Integer addGameToTable(Game game);
    Integer deleteGameById(Integer id);
    Integer updateGameById(Integer id, Game game);
    List<GameResults> getUserGuessVsMachineResultsListForDate (LocalDate date);
    public List<GameResults> getAllResultsForUser (String userName);
}
