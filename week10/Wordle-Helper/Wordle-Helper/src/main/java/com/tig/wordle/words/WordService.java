package com.tig.wordle.words;

import com.tig.wordle.answers.Answer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.log;

@Service
public class WordService {

    private WordDAO wordDAO;


    public WordService(@Qualifier("postgres") WordDAO wordDAO)  {
        this.wordDAO = wordDAO;
    }

    public List<Word> getAllWords() {
        return wordDAO.selectAllWords();
    }

    public List<Word> getAllWordsRankedByScore() {
        return wordDAO.selectAllWordsRankedByScore();
    }

    public Word getWordById(Integer id) {
        return wordDAO.selectWordById(id);
    }

    public Word getWordByName(String nameOfWord) {
        return wordDAO.selectWordByName(nameOfWord);
    }


    public List<Word> getTopWords(Integer numOfWords) {
        return wordDAO.selectTopWords(numOfWords);
    }

    public Boolean wordValidator (String word) {
        List<Word> allWords = getAllWords();
        List <Word> checkWord = allWords.stream()
                .filter(wordInList -> wordInList.getWord().equals(word))
                .collect(Collectors.toList());

        if (!checkWord.isEmpty()) {
            return true;
        }
        else throw new WordNotValidException("Invalid Entry. Word is not in word list");
    }

    public List<Word> setUniformProbabilities(List<Word> wordList) {
        // For our list of words set probabilities to be equal
        // Placeholder
        Word currentWord;
        for (int i = 0; i < wordList.size(); i++) {
            currentWord = wordList.get(i);
            currentWord.setProbability(1.0 / wordList.size());
            wordList.set(i, currentWord);
        }
        return wordList;
    }

    public LinkedHashMap<String, String> generateWordPattern(Word word, Word targetWord) {
        // Initialise empty map
        LinkedHashMap<String, String> pattern = new LinkedHashMap<>();
        // Set arrays for the characters
        Character[] lettersInWord = new Character[word.getWord().length()];
        Character[] lettersInTarget = new Character[targetWord.getWord().length()];
        // Loop over and check for green letters
        for (int i = 0; i < lettersInWord.length; i++) {
            lettersInWord[i] = word.getWord().charAt(i);
            lettersInTarget[i] = targetWord.getWord().charAt(i);
            if (lettersInWord[i] == lettersInTarget[i]) {
                // Set this letter to green in the pattern
                pattern.put(String.valueOf(lettersInWord[i]) + i, "green");
                // Indicate these letters are spent
                lettersInWord[i] = null;
                lettersInTarget[i] = null;
            }
        }
        // Loop over and check for orange letters
        for (int i = 0; i < lettersInWord.length; i++) {
            if (lettersInWord[i] != null) {
                // Loop over letters in target word
                for (int j = 0; j < lettersInTarget.length; j++) {
                    if (lettersInWord[i] == lettersInTarget[j]) {
                        // Set this letter to orange in the pattern
                        pattern.put(String.valueOf(lettersInWord[i]) + i, "yellow");
                        // Indicate these letters are spent
                        lettersInWord[i] = null;
                        lettersInTarget[j] = null;
                        break;
                    }
                }
            }
        }
        // Loop over and check for greys
        for (int i = 0; i < lettersInWord.length; i++) {
            if (lettersInWord[i] != null) {
                // Set letter to grey in pattern
                pattern.put(String.valueOf(lettersInWord[i]) + i, "grey");
            }
        }
        return pattern;
    }

    public boolean checkPatternMatch(Word word, Word targetWord, LinkedHashMap<String, String> pattern) {
        // Pattern for target word
        LinkedHashMap<String, String> newPattern = generateWordPattern(word, targetWord);
        // Compares patterns
        boolean result = pattern.equals(newPattern);
        return result;
    }

    public List<Word> findMatchingWords(Word guess, List<Word> wordList, LinkedHashMap<String, String> pattern) {
        // Initialise list of remaining words
        List<Word> remainingWords = new ArrayList<>();
        // Loop through word list
        for (int i = 0; i < wordList.size(); i++) {
            if (checkPatternMatch(guess, wordList.get(i), pattern)) {
                remainingWords.add(wordList.get(i));
            }
        }
        return remainingWords;
    }

    public Double computePatternProbability(Word guess, List<Word> wordList, LinkedHashMap<String, String> pattern) {
        // Initialise sum variable
        Double sum = 0.0;
        // Loop through remaining word list made using findMatchingWords method (above), get probabilities, and sum together
        List<Word> remainingWords = findMatchingWords(guess, wordList, pattern);
        for (Word remainingWord : remainingWords) {
            sum += remainingWord.getProbability();
        }
        return sum;
    }

    public Double logTwo(Double value){
        return log(value)/log(2);
    }

    public Double computeWordScore(Word word, List<Word> wordList) {
        // Loop over all the words. Generate pattern for each one, add to list of patterns if unique
        List<LinkedHashMap> patterns = new ArrayList<>();
        LinkedHashMap<String, String> newPattern;
        for (int i = 0; i < wordList.size(); i++) {
            newPattern = generateWordPattern(word,wordList.get(i));
            if (!patterns.contains(newPattern)){
                patterns.add(newPattern);
            }

        }

        Double probability;
        double score = 0;
        for (int i = 0; i < patterns.size(); i++) {
            probability = computePatternProbability(word, wordList, patterns.get(i));
            score = score - probability * logTwo(probability);

        }
        return score;

    }

    public List <Word> computeScoreDistribution (List<Word> wordList) {
        // Method goes through wordlist, calculates score for each word, sets the score of that word to the score that it calculated
        Double score;
        for (int i = 0; i < wordList.size(); i++) {
            score = computeWordScore(wordList.get(i), wordList);
            wordList.get(i).setScore(score);
        }
        return wordList;

    }

    public Answer getGuessesForAnswer(Answer answer){
        // Get list of words ordered by score
        List<Word> guessList = wordDAO.selectAllWordsRankedByScore();
        // Boolean to track whether game is currently running
        boolean running = true;
        // Counter for number of guesses
        Integer numberOfGuesses = 0;
        // Get equivalent Word object for answer
        Word wordAnswer = wordDAO.selectWordByName(answer.getAnswerOfDay());
        // Placeholder pattern
        LinkedHashMap<String, String> pattern;
        // Best current guess
        Word guess;
        while(running){
            numberOfGuesses++;
            // Get highest scoring word from sorted guess list
            guess = guessList.get(0);
            // Generate pattern and find all matching words
            pattern = generateWordPattern(guess, wordAnswer);
            guessList = findMatchingWords(guess, guessList, pattern);
            // Recompute probabilities and scores
            guessList = setUniformProbabilities(guessList);
            guessList = computeScoreDistribution(guessList);
            // Sort by score
            guessList = guessList.stream()
                    .sorted(Comparator.comparing(Word::getScore).reversed())
                    .collect(Collectors.toList());
            // Check if guess matches answer
            if (guessList.get(0).getWord().equals(answer.getAnswerOfDay())){
                numberOfGuesses++;
                running = false;
            }
        }
        // Update number of guesses in answer
        answer.setMachineResult(numberOfGuesses);
        return answer;
    }

}

