package com.tig.wordle.games;

import com.tig.wordle.answers.Answer;
import com.tig.wordle.words.Word;
import com.tig.wordle.words.WordDAO;
import com.tig.wordle.words.WordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class GameServiceTest {
    private GameService underTest;
    private GameDAO gameDAO;


    @BeforeEach
    void setUp(){
        this.gameDAO = Mockito.mock(GameDAO.class);
        this.underTest = new GameService (gameDAO);
    }

    @Test
    void getAllGames (){
        // Given
        Game testGame1 = new Game(1, 2, 3, 4);
        Game testGame2 = new Game(5, 6, 7, 8);
        Game testGame3 = new Game(9, 10, 11, 12);
        Game testGame4 = new Game(13, 14, 15, 16);

        List<Game> allGames = new ArrayList<>();
        allGames.add(testGame1);
        allGames.add(testGame2);
        allGames.add(testGame3);
        allGames.add(testGame4);
        given(gameDAO.getAllGames()).willReturn(allGames);
        // When
        List<Game> actual = underTest.getAllGames();
        // Then
        List<Game> expected = allGames;
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void canThrowExceptionWhenGettingAllGames (){
        // Given
        Game testGame1 = new Game(1, 2, 3, 4);
        Game testGame2 = new Game(5, 6, 7, 8);


        List<Game> allGames = new ArrayList<>();

        given(gameDAO.getAllGames()).willReturn(allGames);

        assertThatThrownBy(() -> {
            underTest.getAllGames();}
        ).hasMessage("No games found");

    }

    @Test
    void getGameById () {
        // Given
        Game testGame1 = new Game(1, 2, 3, 4);
        Game testGame2 = new Game(2, 6, 7, 8);
        Game testGame3 = new Game(3, 10, 11, 12);


        List<Game> allGameById= new ArrayList<>();
        allGameById.add(testGame1);
        allGameById.add(testGame2);
        allGameById.add(testGame3);


        given(gameDAO.getAllGames()).willReturn(allGameById);

        given(gameDAO.getGameById(2)).willReturn(testGame2);
        // When
        Game actual = underTest.getGameById(2);
        // Then
        Game expected = testGame2;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowExceptionWhenGettingGameById() {
        // Create objects
        Game testGame1 = new Game(1, 2, 3, 4);
        Game testGame2 = new Game(2, 6, 7, 8);
        Game testGame3 = new Game(3, 10, 11, 12);


        List<Game> allGameById= new ArrayList<>();
        allGameById.add(testGame1);
        allGameById.add(testGame2);
        allGameById.add(testGame3);

        given(gameDAO.getAllGames()).willReturn(allGameById);

        assertThatThrownBy(() -> {
            underTest.getGameById(20);}
        ).hasMessage("Game with ID 20 does not exist");

    }
    @Test
    void canAddGameToTable () {
        // Given
        Game testGame1 = new Game(1, 2, 3, 4);


        given(gameDAO.addGameToTable(testGame1)).willReturn(1);

        // When
       Integer actual = underTest.addGameToTable(testGame1);
        // Then
        Integer expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowExceptionWhenaddingGameToTable() {

        Game testGame1 = new Game(1, null, 3, 4);

        assertThatThrownBy(() -> {
            underTest.addGameToTable(testGame1);}
        ).hasMessage("Fields cannot be empty");

    }

}
