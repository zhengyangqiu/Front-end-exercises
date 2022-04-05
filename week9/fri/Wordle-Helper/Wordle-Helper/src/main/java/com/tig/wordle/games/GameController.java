package com.tig.wordle.games;

import com.tig.wordle.answers.Answer;
import com.tig.wordle.answers.AnswerService;
import com.tig.wordle.user.UserService;
import com.tig.wordle.words.Word;
import com.tig.wordle.words.WordService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("competitive")
public class GameController {
    private GameService gameService;
    private UserService userService;
    private WordService wordService;
    private AnswerService answerService;
    private LinkedHashMap<Integer, Answer> answersOfDay;
    private LinkedHashMap<Integer, List<Word>> gameWordLists;
    private LinkedHashMap<Integer, Integer> userGuesses;

    public GameController(GameService gameService,
                          UserService userService,
                          WordService wordService,
                          AnswerService answerService) {
        this.gameService = gameService;
        this.userService = userService;
        this.wordService = wordService;
        this.answerService = answerService;
        this.answersOfDay = new LinkedHashMap<>();
        this.gameWordLists = new LinkedHashMap<>();
        this.userGuesses = new LinkedHashMap<>();
    }
    @GetMapping("all")
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }
    @GetMapping("{id}")
    public Game getGameById(@PathVariable("id") Integer id){
        return gameService.getGameById(id);
    }
    @PostMapping("addgame")
    public Integer addGameToTable(@RequestBody Game game){
        return gameService.addGameToTable(game);
    }
    @DeleteMapping("{id}")
    public Integer deleteGameById(@PathVariable("id") Integer id){
        return gameService.deleteGameById(id);
    }
    @PutMapping("{id}")
    public Integer updateGameById(@PathVariable("id") Integer id,
                                  @RequestBody Game game){
        return gameService.updateGameById(id, game);
    }

    @PutMapping(path = "computemachinescores")
    public void computeMachineScores(){
        // Get list of answers from answer table
        List<Answer> answerList = answerService.getAllAnswers();
        // Placeholder for answers with machine scores computed
        Answer answerWithMachineGuesses;
        for (int i = 0; i < answerList.size(); i++){
            // Add machine guesses for answer
            answerWithMachineGuesses = wordService.getGuessesForAnswer(answerList.get(i));
            System.out.println("id " + answerWithMachineGuesses.getId()
                    + ": " + answerWithMachineGuesses.getAnswerOfDay() + " guessed in "
                    + answerWithMachineGuesses.getMachineResult());
            // Update score in answer table
            answerService.updateAnswerById(answerWithMachineGuesses.getId(),
                    answerWithMachineGuesses);
        }
    }

    @GetMapping(path = "dailyresults/{date}")
    public List <GameResults> getAllResultsVsMachineForDate (@PathVariable("date") String date) {
        return gameService.getAllResultsVsMachineForDate(Date.valueOf(date).toLocalDate());
    }
    @GetMapping(path = "userresults/{username}/{date}")
    public GameResults getResultForGivenUserVsMachineForDate (@PathVariable("date") String date,
                                                             @PathVariable("username") String username) {
        return gameService.getUserResultForDay(Date.valueOf(date).toLocalDate(), username);
    }
    @GetMapping(path = "userresults/{username}")
    public List<GameResults> getUserResults(@PathVariable("username") String userName){
        return gameService.getAllResultsVsMachineForUser(userName);
    }
    @GetMapping(path = "averageresults/{username}")
    public Double getUserResultsAverage(@PathVariable("username") String userName){
        return gameService.getAverageGuessesForUser(userName);
    }

    @GetMapping(path = "start/{userId}")
    public List<Word> startUserGame(@PathVariable("userId") Integer userId){
        // Get list of answers
        List<Answer> allAnswers = answerService.getAllAnswers();
        // Get today's answer
        Answer answerToday = allAnswers.stream()
                .filter(answer -> answer.getDateOfAnswer().equals(LocalDate.now()))
                .collect(Collectors.toList()).get(0);
        // Track progression of game
        this.answersOfDay.put(userId, answerToday);
        this.gameWordLists.put(userId, wordService.getAllWords());
        this.userGuesses.put(userId, 0);

        return gameWordLists.get(userId);
    }
    @DeleteMapping(path = "start/{userid}/{guess}")
    public List<Word> executeUserGuess(@PathVariable("userid") Integer userId,
                                       @PathVariable("guess") String guess){
        // Get our guess from the list
        Word guessWord = gameWordLists.get(userId).stream()
                .filter(wordInList -> wordInList.getWord().equals(guess))
                .collect(Collectors.toList()).get(0);
        // Get equivalent Word object for answer
        Word wordAnswer = wordService.getWordByName(answersOfDay.get(userId).getAnswerOfDay());
        // Get pattern for guess
        LinkedHashMap<String, String> pattern = wordService.generateWordPattern(guessWord, wordAnswer);
        // Reduce game list
        this.gameWordLists.put(userId, wordService.findMatchingWords(guessWord, gameWordLists.get(userId), pattern));
        // Update user guesses
        this.userGuesses.put(userId, userGuesses.get(userId) + 1);
        return gameWordLists.get(userId);
    }

    @PostMapping(path = "start/{userid}/end")
    public Integer submitUserGameScore(@PathVariable("userid") Integer userId){
        // Create game object
        Game gameEntry = new Game();
        gameEntry.setUserId(userId);
        gameEntry.setAnswerId(answersOfDay.get(userId).getId());
        gameEntry.setUserGuesses(userGuesses.get(userId));
        // Post score
        Integer rowsAffected = gameService.addGameToTable(gameEntry);
        // Clear game entries
        this.answersOfDay.remove(userId);
        this.gameWordLists.remove(userId);
        this.userGuesses.remove(userId);
        return rowsAffected;
    }

}
