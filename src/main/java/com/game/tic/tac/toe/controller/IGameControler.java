package com.game.tic.tac.toe.controller;

import java.util.List;

import com.game.tic.tac.toe.models.Cell;
import com.game.tic.tac.toe.models.GameTicTacToe;

public interface IGameControler {

	/**
	 * Init Cells
	 * 
	 * @return Cell list
	 */
	List<Cell> initialiserCells();

	/**
	 * Change Player Turn
	 * 
	 * @param id    id
	 * @param state state
	 * @return GameTicTacToe
	 */
	GameTicTacToe changePlayerTurn(Integer id, String state);

	/**
	 * Init Game
	 * 
	 * @return GameTicTacToe
	 */
	GameTicTacToe initialiserGame();

	/**
	 * Check if the is GameOver
	 * 
	 * @return true or false
	 */
	boolean isGameOver();

	/**
	 * Check if the is Winner
	 * 
	 * @return true or false
	 */
	boolean isWinner();

}
