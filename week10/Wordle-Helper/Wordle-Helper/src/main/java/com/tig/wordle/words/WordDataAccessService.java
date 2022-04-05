package com.tig.wordle.words;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class WordDataAccessService implements WordDAO {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Word> wordRowMapper = (rs, rowNum) -> {
        Word word = new Word(
                rs.getInt("id"),
                rs.getString("word"),
                rs.getDouble("probability"),
                rs.getDouble("score")
        );
        return word;
    };

    public WordDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SelectAllWords method
    @Override
    public List<Word> selectAllWords() {
        String sql = """
                SELECT id, word, probability, score
                FROM original_word_list
                """;

        List<Word> gameWordList = jdbcTemplate.query(sql, wordRowMapper);
        return gameWordList;
    }

    @Override
    public List<Word> selectAllWordsRankedByScore() {
        String sql = """
                SELECT id, word, probability, score
                FROM original_word_list ORDER BY score DESC
                """;

        List<Word> gameWordList = jdbcTemplate.query(sql, wordRowMapper);
        return gameWordList;
    }

    @Override
    public List<Word> selectTopWords(Integer numOfWords) {
        String sql = """
                SELECT id, word, probability, score
                FROM original_word_list ORDER BY score DESC limit ?
                """;

        List<Word> gameWordList = jdbcTemplate.query(sql, wordRowMapper, numOfWords);
        return gameWordList;
    }

    @Override
    public Word selectWordById(Integer id) {
        String sql = """
                SELECT id, word, probability, score
                FROM original_word_list
                WHERE id=?
                """;

        Word wordById = jdbcTemplate.query(sql, wordRowMapper, id).get(0);
        return wordById;

    }

    @Override
    public Word selectWordByName(String nameOfWord) {
        String sql = """
                SELECT id, word, probability, score
                FROM original_word_list
                WHERE word=?
                """;

        Word word = jdbcTemplate.query(sql, wordRowMapper, nameOfWord).get(0);
        return word;
    }

}
