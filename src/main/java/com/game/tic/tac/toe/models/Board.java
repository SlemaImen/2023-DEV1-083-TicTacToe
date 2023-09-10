package com.game.tic.tac.toe.models;

import java.util.List;

public class Board {
	
    private List<Cell> cells;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void updateCellState(int id, String state) {
        cells.get(id).setState(state);
    }

    public String getCellState(int id) {
        return cells.get(id).getState();
    }

    public void reset() {
        for (Cell cell : cells) {
            cell.setState(null);
        }
    }
}
