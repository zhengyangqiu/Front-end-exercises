package com.tig.wordle.games;

import com.tig.wordle.answers.AnswerNotFoundException;
import com.tig.wordle.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private GameDAO gameDAO;
    public GameService(@Qualifier("games") GameDAO gameDAO){
        this.gameDAO = gameDAO;
    }

    public List<Game> getAllGames(){
        if(gameDAO.getAllGames().size() == 0) {
            throw new GameNotFoundException("No games found");
        }
        return gameDAO.getAllGames();
    }

    public Boolean doesGameWithIdExists(Integer id) {
        return gameDAO
                .getAllGames()
                .stream()
                .anyMatch(p -> p.getId().equals(id));  // returns boolean
    }

    public Game getGameById(Integer id){
        boolean exists = doesGameWithIdExists(id);
        if (exists == false) {
            throw new GameNotFoundException("Game with ID " + id + " does not exist");
        }
        return gameDAO.getGameById(id);
    }

    public Integer addGameToTable(Game game){
        if(game.getUserId() != null
        && game.getAnswerId()!= null
        && game.getUserGuesses() != null) {
            return gameDAO.addGameToTable(game);
        }
        else throw new InputMissingForGameException("Fields cannot be empty");
    }
    public Integer deleteGameById(Integer id){
        if (gameDAO.getGameById(id) == null){
            throw new GameNotFoundException("Game with ID " + id + " does not exist");
        }
        return gameDAO.deleteGameById(id);
    }
    public Integer updateGameById(Integer id, Game game){
        if (gameDAO.getGameById(id) == null){
            throw new GameNotFoundException("Game with ID " + id + " does not exist");
        }
        if(game.getUserId() != null
                && game.getAnswerId()!= null
                && game.getUserGuesses() != null) {
            return gameDAO.updateGameById(id, game);
        }
        else throw new InputMissingForGameException("Fields cannot be empty");

    }

    public List<GameResults> getAllResultsVsMachineForDate (LocalDate date) {
        return gameDAO.getUserGuessVsMachineResultsListForDate(date);
    }
    public GameResults getUserResultForDay(LocalDate date, String userName){
        // Get all for results for day
        List<GameResults> gameResultsForDay = getAllResultsVsMachineForDate(date);
        // Find all entries with that username
        List<GameResults> userResults = gameResultsForDay.stream()
                .filter(gameResult -> gameResult.getUserName().equals(userName))
                .collect(Collectors.toList());
        if (userResults.isEmpty()){
            return null;
        }
        return userResults.get(0);
    }
    public List<GameResults> getAllResultsVsMachineForUser(String userName){
        return gameDAO.getAllResultsForUser(userName);
    }
    public Double getAverageGuessesForUser(String username){
        List<GameResults> userResults = gameDAO.getAllResultsForUser(username);
        Double average = 0.0;
        for (int i = 0; i < userResults.size(); i++) {
            average += userResults.get(i).getGuessesTaken();
        }
        average = average/userResults.size();
        return average;
    }
}
