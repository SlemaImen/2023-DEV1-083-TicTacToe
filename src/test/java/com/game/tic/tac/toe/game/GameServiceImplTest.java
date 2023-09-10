package com.game.tic.tac.toe.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.game.tic.tac.toe.models.Cell;
import com.game.tic.tac.toe.models.GameTicTacToe;

public class GameServiceImplTest {

	private GameServiceImpl gameService;

	@BeforeEach
	public void setUp() {
		gameService = new GameServiceImpl();
	}

	@Test
	public void initialiserCells_ShouldReturnInitialCells() {
		List<Cell> cells = gameService.initialiserCells();
		assertNotNull(cells);
		assertEquals(9, cells.size());
	}

	@Test
	public void changePlayerTurn_WhenNoWinner_ShouldChangePlayerAndIncrementTurnCount() {
		Cell mockCell = new Cell(0, "X");
		GameTicTacToe mockGame = Mockito.mock(GameTicTacToe.class);
		when(mockGame.getTurnCount()).thenReturn(1);
		when(mockGame.isWinner()).thenReturn(false);
		when(mockGame.getActivePlayer()).thenReturn("X");

		GameTicTacToe result = gameService.changePlayerTurn(mockCell);

		assertNotNull(result);
		assertEquals("X", result.getActivePlayer());
		assertEquals(1, result.getTurnCount());
	}

	@Test
	public void changePlayerTurn_WhenWinner_ShouldSetWinnerAndGameOver() {
		Cell mockCell = new Cell(0, "X");
		GameTicTacToe game = new GameTicTacToe();
		game.setTurnCount(1);
		game.setWinner(true);
		game.setGameOver(true);

		GameTicTacToe result = gameService.changePlayerTurn(mockCell);

		assertNotNull(result);
		assertTrue(game.isWinner());
		assertFalse(result.isGameRunning());
		assertTrue(game.isGameOver());
	}

}
