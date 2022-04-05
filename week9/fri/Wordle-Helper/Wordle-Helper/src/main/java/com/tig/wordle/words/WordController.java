package com.tig.wordle.words;

import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("helper")
public class WordController {

    private WordService wordService;
    private List<Word> gameList;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public List <Word> getAllWords () {
        return wordService.getAllWords();
    }

    @GetMapping("ranked")
    public List <Word> getAllWordsRankedByScore () {
        return wordService.getAllWordsRankedByScore();
    }

    @GetMapping (path = "ranked/{numOfWords}")
    public List <Word> getTopWords (@PathVariable("numOfWords") Integer numOfWords) {
        return wordService.getTopWords(numOfWords);
    }

    @GetMapping (path = "wordbyid/{id}")
    public Word getWordById (@PathVariable("id") Integer id) {
        return wordService.getWordById(id);
    }

    @GetMapping (path = "wordbyname/{nameofword}")
    public Word getWordByName(@PathVariable("nameofword") String nameOfWord) {
        return wordService.getWordByName(nameOfWord);
    }

    @GetMapping("start")
    public List <Word> startGame() {
        this.gameList = wordService.getAllWordsRankedByScore();
        return gameList;
    }

    @DeleteMapping("start/{word}")
    public List <Word> guessWord(@PathVariable("word") String word,
                                 @RequestBody LinkedHashMap<String, String> pattern){

        // Check that user guess is in list of possible words
        wordService.wordValidator(word);

        // Get our guess from the list
        Word wordFromList = gameList.stream()
                .filter(wordInList -> wordInList.getWord().equals(word))
                .collect(Collectors.toList()).get(0);
        // Remove words that don't match word and pattern
        this.gameList = wordService.findMatchingWords(wordFromList, gameList, pattern);

        // Update probabilities and scores
        this.gameList = wordService.setUniformProbabilities(gameList);
        this.gameList = wordService.computeScoreDistribution(gameList);
        // Sort by scores in descending order
        this.gameList = gameList.stream()
                .sorted(Comparator.comparing(Word::getScore).reversed())
                .collect(Collectors.toList());
        return gameList;
    }


    // this was an extra step, can be used for development later. currently included in delete request
//    @PutMapping("game/updatescores")
//    public List <Word> updateScores(){
//        // Update probabilities and scores
//        this.gameList = wordService.setUniformProbabilities(gameList);
//        this.gameList = wordService.computeScoreDistribution(gameList);
//        // Sort by scores in descending order
//        this.gameList = gameList.stream()
//                .sorted(Comparator.comparing(Word::getScore).reversed())
//                .collect(Collectors.toList());
//        return gameList;
//    }

    @DeleteMapping("endgame")
    public List<Word> endGame(){
        this.gameList.clear();
        return gameList;
    }
}
