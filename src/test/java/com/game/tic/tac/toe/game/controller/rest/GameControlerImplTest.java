package com.game.tic.tac.toe.game.controller.rest;
import com.game.tic.tac.toe.controller.GameControlerImpl;
import com.game.tic.tac.toe.game.IGameService;
import com.game.tic.tac.toe.models.Cell;
import com.game.tic.tac.toe.models.GameTicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class GameControlerImplTest {

    private GameControlerImpl gameController;
    private IGameService gameService;

    @BeforeEach
    void setUp() {
        gameService = Mockito.mock(IGameService.class);
        gameController = new GameControlerImpl(gameService);
    }

    @Test
    void testInitialiserCells() {
        List<Cell> cells = new ArrayList<>();
        when(gameService.initialiserCells()).thenReturn(cells);

        List<Cell> result = gameController.initialiserCells();

        assertEquals(cells, result);
    }

    @Test
    void testInitialiserGame() {
        GameTicTacToe game = new GameTicTacToe();
        when(gameService.initialiserGame()).thenReturn(game);

        GameTicTacToe result = gameController.initialiserGame();

        assertEquals(game, result);
    }

    @Test
    void testChangePlayerTurn() {
        int id = 0;
        String state = "X";
        Cell squareClicked = new Cell(id, state);
        GameTicTacToe game = new GameTicTacToe();
        when(gameService.changePlayerTurn(squareClicked)).thenReturn(game);

        GameTicTacToe result = gameController.changePlayerTurn(id, state);

        assertNotNull(game);
    }

    @Test
    void testIsGameOver() {
        when(gameService.isGameOver()).thenReturn(true);

        boolean result = gameController.isGameOver();

        assertEquals(true, result);
    }

    @Test
    void testIsWinner() {
        when(gameService.isWinner()).thenReturn(true);

        boolean result = gameController.isWinner();

        assertEquals(true, result);
    }
}
