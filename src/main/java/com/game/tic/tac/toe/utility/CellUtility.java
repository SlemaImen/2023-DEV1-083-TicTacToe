package com.game.tic.tac.toe.utility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.game.tic.tac.toe.models.Cell;

public class CellUtility {

	/**
	 * Creer les cellules d'un jeux
	 * 
	 * @return Cell List
	 */
	public static List<Cell> createCells() {
		return IntStream.range(0, 9).mapToObj(i -> new Cell(i, null)).collect(Collectors.toList());
	}

	/**
	 * Update Cell State
	 * 
	 * @param cells cells
	 * @param id    id
	 * @param state state
	 */
	public static void updateCellState(List<Cell> cells, int id, String state) {
		cells.get(id).setState(state);
	}

	/**
	 * Get Cell State
	 * 
	 * @param cells cells
	 * @param id    id
	 * @return cells
	 */
	public static String getCellState(List<Cell> cells, int id) {
		return cells.get(id).getState();
	}

	/**
	 * Reset Cells
	 * 
	 * @param cells
	 */
	public static void resetCells(List<Cell> cells) {
		for (Cell cell : cells) {
			cell.setState(null);
		}
	}
}