package com.game.tic.tac.toe.game;

import com.game.tic.tac.toe.models.Cell;
import com.game.tic.tac.toe.models.GameTicTacToe;

import java.util.List;

public interface IGameService {

	List<Cell> initialiserCells();

	GameTicTacToe changePlayerTurn(Cell squareClicked);

	boolean isGameOver();

	boolean isWinner();
	
	GameTicTacToe initialiserGame();
}
