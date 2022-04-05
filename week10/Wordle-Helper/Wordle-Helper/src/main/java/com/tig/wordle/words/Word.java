package com.tig.wordle.words;

import java.util.Objects;

public class Word {
    private Integer id;
    private String word;
    private Double probability;
    private Double score;

    public Word(){

    }
    public Word(Integer id, String word, Double probability, Double score) {
        this.id = id;
        this.word = word;
        this.probability = probability;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", probability=" + probability +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(id, word1.id) && Objects.equals(word, word1.word) && Objects.equals(probability, word1.probability) && Objects.equals(score, word1.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, probability, score);
    }
}
