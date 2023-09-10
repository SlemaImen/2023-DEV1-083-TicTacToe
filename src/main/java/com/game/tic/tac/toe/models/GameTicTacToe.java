package com.game.tic.tac.toe.models;

import java.util.ArrayList;
import java.util.List;

public class GameTicTacToe {

	private String activePlayer = "X";
	private Integer turnCount = 0;
	private boolean isGameRunning = false;
	private boolean winner = false;
	private boolean isGameOver = false;
	private Board board = new Board();
	private List<Board> boardList = new ArrayList<>();
	private Integer boardSize = 9;
	private String sessionId;

	public GameTicTacToe() {
		super();
		this.activePlayer = "X";
		this.turnCount = 0;
		this.isGameRunning = false;
		this.isGameOver = false;
		this.winner = false;
		this.board = createBoard();
		this.boardList.add(board); 
	}

	public Board createBoard() {
		Board board = new Board();
		List<Cell> cells = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			Cell cell = new Cell(i, null);
			cells.add(cell);
		}
		board.setCells(cells);
		return board;
	}

	public String getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(String activePlayer) {
		this.activePlayer = activePlayer;
	}

	public Integer getTurnCount() {
		return turnCount;
	}

	public void setTurnCount(Integer turnCount) {
		this.turnCount = turnCount;
	}

	public boolean isGameRunning() {
		return isGameRunning;
	}

	public void setGameRunning(boolean isGameRunning) {
		this.isGameRunning = isGameRunning;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}

	public Integer getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(Integer boardSize) {
		this.boardSize = boardSize;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	

}
