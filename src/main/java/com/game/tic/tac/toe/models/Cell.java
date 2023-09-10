package com.game.tic.tac.toe.models;

public class Cell {
    private int id;
    private String state;

    public Cell(int id, String state) {
        this.id = id;
        this.state = null;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
