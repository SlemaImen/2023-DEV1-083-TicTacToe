package com.game.tic.tac.toe.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.game.tic.tac.toe.models.Cell;
import com.game.tic.tac.toe.utility.CellUtility;

public class CellUtilityTest {

	private List<Cell> cells;

	@BeforeEach
	void setUp() {
		cells = CellUtility.createCells();
	}

	@Test
	void testCreateCells() {
		assertNotNull(cells);
		assertEquals(9, cells.size());
	}

	@Test
	void testUpdateCellState() {
		CellUtility.updateCellState(cells, 0, "X");
		assertEquals("X", CellUtility.getCellState(cells, 0));
	}

	@Test
	void testGetCellState() {
		CellUtility.updateCellState(cells, 1, "O");
		assertEquals("O", CellUtility.getCellState(cells, 1));
	}

	@Test
	void testResetCells() {
		CellUtility.updateCellState(cells, 2, "X");
		CellUtility.resetCells(cells);
		assertNull(CellUtility.getCellState(cells, 2));
	}
}
